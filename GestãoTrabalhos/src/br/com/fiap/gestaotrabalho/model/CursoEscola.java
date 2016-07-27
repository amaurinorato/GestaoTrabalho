package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;


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
	private int id_Curso_escola;

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

	public int getId_Curso_escola() {
		return this.id_Curso_escola;
	}

	public void setId_Curso_escola(int id_Curso_escola) {
		this.id_Curso_escola = id_Curso_escola;
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