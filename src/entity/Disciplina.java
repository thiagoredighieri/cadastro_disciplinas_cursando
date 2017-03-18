/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author thiagoredi
 */
public class Disciplina {
        private int iddisciplina;
	private String nome;
        private Double carga_horaria;
        private String curso;
        private int num_vagas;
	private int periodo;

    public int getIddisciplina() {
        return iddisciplina;
    }

    public String getNome() {
        return nome;
    }

    public Double getCarga_horaria() {
        return carga_horaria;
    }

    public String getCurso() {
        return curso;
    }

    public int getNum_vagas() {
        return num_vagas;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarga_horaria(Double carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNum_vagas(int num_vagas) {
        this.num_vagas = num_vagas;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
}
