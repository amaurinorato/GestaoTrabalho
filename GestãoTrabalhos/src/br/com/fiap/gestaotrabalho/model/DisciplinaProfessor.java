package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the disciplina_professor database table.
 * 
 */
@Entity
@Table(name="disciplina_professor")
@NamedQuery(name="DisciplinaProfessor.findAll", query="SELECT d FROM DisciplinaProfessor d")
public class DisciplinaProfessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_disciplina_professor")
	private int idDisciplinaProfessor;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private Usuario usuario;

	public DisciplinaProfessor() {
	}

	public int getIdDisciplinaProfessor() {
		return this.idDisciplinaProfessor;
	}

	public void setIdDisciplinaProfessor(int idDisciplinaProfessor) {
		this.idDisciplinaProfessor = idDisciplinaProfessor;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}