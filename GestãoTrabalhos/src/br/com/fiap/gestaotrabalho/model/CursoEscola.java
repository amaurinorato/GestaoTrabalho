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
 * The persistent class for the curso_escola database table.
 * 
 */
@Entity
@Table(name="curso_escola")
@NamedQuery(name="CursoEscola.findAll", query="SELECT c FROM CursoEscola c")
public class CursoEscola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_curso_escola")
	private int idCursoEscola;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="Id_curso")
	private Curso curso;

	//bi-directional many-to-one association to Escola
	@ManyToOne
	@JoinColumn(name="id_escola")
	private Escola escola;

	public CursoEscola() {
	}

	public int getIdCursoEscola() {
		return idCursoEscola;
	}

	public void setIdCursoEscola(int idCursoEscola) {
		this.idCursoEscola = idCursoEscola;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Escola getEscola() {
		return this.escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

}