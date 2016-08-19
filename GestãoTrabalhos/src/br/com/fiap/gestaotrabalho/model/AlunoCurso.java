package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the aluno_curso database table.
 * 
 */
@Entity
@Table(name="aluno_curso")
@NamedQuery(name="AlunoCurso.findAll", query="SELECT a FROM AlunoCurso a")
public class AlunoCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Aluno_curso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_aluno")
	private Usuario aluno;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	public AlunoCurso() {
	}

	public int getId_Aluno_curso() {
		return this.id_Aluno_curso;
	}

	public void setId_Aluno_curso(int id_Aluno_curso) {
		this.id_Aluno_curso = id_Aluno_curso;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}