package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trabalho_aluno database table.
 * 
 */
@Entity
@Table(name="trabalho_aluno")
@NamedQuery(name="TrabalhoAluno.findAll", query="SELECT t FROM TrabalhoAluno t")
public class TrabalhoAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Trabalho_aluno;

	private double nota;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_aluno")
	private Usuario usuario;

	//bi-directional many-to-one association to Trabalho
	@ManyToOne
	@JoinColumn(name="id_trabalho")
	private Trabalho trabalho;

	public TrabalhoAluno() {
	}

	public int getId_Trabalho_aluno() {
		return this.id_Trabalho_aluno;
	}

	public void setId_Trabalho_aluno(int id_Trabalho_aluno) {
		this.id_Trabalho_aluno = id_Trabalho_aluno;
	}

	public double getNota() {
		return this.nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Trabalho getTrabalho() {
		return this.trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

}