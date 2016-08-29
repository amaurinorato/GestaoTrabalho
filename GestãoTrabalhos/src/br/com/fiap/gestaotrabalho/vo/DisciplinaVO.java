package br.com.fiap.gestaotrabalho.vo;

import java.io.Serializable;
import java.util.List;

import br.com.fiap.gestaotrabalho.model.TrabalhoAluno;

public class DisciplinaVO implements Serializable {
	
	private String nome;
	private double notaFinal;
	private String status;
	private List<TrabalhoAluno> trabalhos;
	
	public List<TrabalhoAluno> getTrabalhos() {
		return trabalhos;
	}
	public void setTrabalhos(List<TrabalhoAluno> trabalhos) {
		this.trabalhos = trabalhos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
