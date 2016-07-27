package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Disciplina;

	@Column(name="carga_horaria")
	private int cargaHoraria;

	private String nome;

	//bi-directional many-to-one association to CursoDisciplina
	@OneToMany(mappedBy="disciplina")
	private List<CursoDisciplina> cursoDisciplinas;

	//bi-directional many-to-one association to DisciplinaProfessor
	@OneToMany(mappedBy="disciplina")
	private List<DisciplinaProfessor> disciplinaProfessors;

	//bi-directional many-to-one association to Trabalho
	@OneToMany(mappedBy="disciplina")
	private List<Trabalho> trabalhos;

	public Disciplina() {
	}

	public int getId_Disciplina() {
		return this.id_Disciplina;
	}

	public void setId_Disciplina(int id_Disciplina) {
		this.id_Disciplina = id_Disciplina;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CursoDisciplina> getCursoDisciplinas() {
		return this.cursoDisciplinas;
	}

	public void setCursoDisciplinas(List<CursoDisciplina> cursoDisciplinas) {
		this.cursoDisciplinas = cursoDisciplinas;
	}

	public CursoDisciplina addCursoDisciplina(CursoDisciplina cursoDisciplina) {
		getCursoDisciplinas().add(cursoDisciplina);
		cursoDisciplina.setDisciplina(this);

		return cursoDisciplina;
	}

	public CursoDisciplina removeCursoDisciplina(CursoDisciplina cursoDisciplina) {
		getCursoDisciplinas().remove(cursoDisciplina);
		cursoDisciplina.setDisciplina(null);

		return cursoDisciplina;
	}

	public List<DisciplinaProfessor> getDisciplinaProfessors() {
		return this.disciplinaProfessors;
	}

	public void setDisciplinaProfessors(List<DisciplinaProfessor> disciplinaProfessors) {
		this.disciplinaProfessors = disciplinaProfessors;
	}

	public DisciplinaProfessor addDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		getDisciplinaProfessors().add(disciplinaProfessor);
		disciplinaProfessor.setDisciplina(this);

		return disciplinaProfessor;
	}

	public DisciplinaProfessor removeDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		getDisciplinaProfessors().remove(disciplinaProfessor);
		disciplinaProfessor.setDisciplina(null);

		return disciplinaProfessor;
	}

	public List<Trabalho> getTrabalhos() {
		return this.trabalhos;
	}

	public void setTrabalhos(List<Trabalho> trabalhos) {
		this.trabalhos = trabalhos;
	}

	public Trabalho addTrabalho(Trabalho trabalho) {
		getTrabalhos().add(trabalho);
		trabalho.setDisciplina(this);

		return trabalho;
	}

	public Trabalho removeTrabalho(Trabalho trabalho) {
		getTrabalhos().remove(trabalho);
		trabalho.setDisciplina(null);

		return trabalho;
	}

}