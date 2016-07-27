package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curso_disciplina database table.
 * 
 */
@Entity
@Table(name="curso_disciplina")
@NamedQuery(name="CursoDisciplina.findAll", query="SELECT c FROM CursoDisciplina c")
public class CursoDisciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_CURSO_DISCIPLINA;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="id_curso")
	private Curso curso;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;

	public CursoDisciplina() {
	}

	public int getId_CURSO_DISCIPLINA() {
		return this.id_CURSO_DISCIPLINA;
	}

	public void setId_CURSO_DISCIPLINA(int id_CURSO_DISCIPLINA) {
		this.id_CURSO_DISCIPLINA = id_CURSO_DISCIPLINA;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}