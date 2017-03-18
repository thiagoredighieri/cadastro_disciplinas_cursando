/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dao.DisciplinaDAO;
import entity.Disciplina;
import java.util.List;

/**
 *
 * @author thiagoredi
 */
public class  DisciplinaBLL implements IBLL <Disciplina> {

        @Override
	public int salvar(Disciplina objeto) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return  disciplinaDAO.salvar(objeto);
	}

	public boolean excluir(Disciplina  objeto) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return  disciplinaDAO.excluir(objeto);	
        }

	public List<Disciplina > listar() {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return  disciplinaDAO.listar();	
        }

	public Disciplina  buscarPorNome(String nome) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		return  disciplinaDAO.buscarPorNome(nome);
	}

}