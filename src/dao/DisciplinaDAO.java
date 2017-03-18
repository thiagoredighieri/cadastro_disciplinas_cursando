package dao;

import java.sql.*;
import java.util.*;
import config.Conexao;
import entity.Disciplina;

public class DisciplinaDAO implements IDAO<Disciplina> {


	public int salvar(Disciplina objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		ResultSet resultado = null;
		int codigo = 0;
		String sql;
		try {

			
				
				sql = "insert into disciplina(nome, carga_horaria, curso, num_vagas, periodo) values(?, ?, ?, ?, ? );";
				sqlParametro = conexao.prepareStatement(sql);
				
				sqlParametro.setString(1, objeto.getNome());
				sqlParametro.setDouble(2, objeto.getCarga_horaria());
                                sqlParametro.setString(3, objeto.getCurso());
				sqlParametro.setInt(4, objeto.getNum_vagas());
                                sqlParametro.setInt(5, objeto.getPeriodo());
				
				
				sqlParametro.executeUpdate();
				
				sql = "select last_insert_id() as iddisciplina";
				sqlParametro = conexao.prepareStatement(sql);
				
				resultado = sqlParametro.executeQuery();
				if (resultado.next()) {
					codigo = resultado.getInt("iddisciplina");
				}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return codigo;
	}

	public boolean excluir(Disciplina objeto) {

		Connection conexao = new Conexao().geraConexao();
		PreparedStatement sqlParametro = null;
		String sql;
		boolean teste = false;
		try {
			sql = "delete from disciplina where nome = ?;";
			sqlParametro = conexao.prepareStatement(sql);
			sqlParametro.setString(1, objeto.getNome());
			sqlParametro.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sqlParametro.close();
				conexao.close();
				teste = true;
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return teste;
	}

	public List<Disciplina>  listar() {

		Connection conexao = new Conexao().geraConexao();
		List<Disciplina> lista = new ArrayList<Disciplina>();
		Statement consulta = null;
		ResultSet resultado = null;
		Disciplina objeto = null;
		String sql;
		try {
			sql = "select * from disciplina;";
			consulta = conexao.createStatement();
			resultado = consulta.executeQuery(sql);
			while (resultado.next()) {
				objeto = new Disciplina();
				objeto.setIddisciplina(resultado.getInt("iddisciplina"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setCarga_horaria(resultado.getDouble("carga_horaria"));
                                objeto.setCurso(resultado.getString("curso"));
                                objeto.setNum_vagas(resultado.getInt("num_vagas"));
                                objeto.setPeriodo(resultado.getInt("periodo"));
				lista.add(objeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	public Disciplina  buscarPorNome(String nome) {

		Connection conexao = new Conexao().geraConexao();
                List<Disciplina> lista = new ArrayList<Disciplina>();
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		Disciplina objeto = null;
		String sql;
		try {
			sql = "select * from disciplina where nome = ?;";
			consulta = conexao.prepareStatement(sql);
			consulta.setString(1, nome);
			resultado = consulta.executeQuery();
			if (resultado.next()) {
				objeto = new Disciplina();
				objeto.setIddisciplina(resultado.getInt("iddisciplina"));
				objeto.setNome(resultado.getString("nome"));
				objeto.setCarga_horaria(resultado.getDouble("carga_horaria"));
                                objeto.setCurso(resultado.getString("curso"));
                                objeto.setNum_vagas(resultado.getInt("num_vagas"));
                                objeto.setPeriodo(resultado.getInt("periodo"));
				lista.add(objeto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				consulta.close();
				resultado.close();
				conexao.close();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		return objeto;
	}

    

}