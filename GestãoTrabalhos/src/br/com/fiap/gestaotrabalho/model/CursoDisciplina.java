package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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
	@Column(name="id_curso_disciplina")
	private int idCursoDisciplina;

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
	
	public int getIdCursoDisciplina() {
		return idCursoDisciplina;
	}

	public void setIdCursoDisciplina(int idCursoDisciplina) {
		this.idCursoDisciplina = idCursoDisciplina;
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