package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_usuario")
	private int idUsuario;

	private String cpf;

	private String email;

	private String matricula;

	private String nome;

	//bi-directional many-to-one association to AlunoCurso
	@OneToMany(mappedBy="usuario")
	private List<AlunoCurso> alunoCursos;

	//bi-directional many-to-one association to DisciplinaProfessor
	@OneToMany(mappedBy="usuario")
	private List<DisciplinaProfessor> disciplinaProfessors;

	//bi-directional many-to-one association to TrabalhoAluno
	@OneToMany(mappedBy="usuario")
	private List<TrabalhoAluno> trabalhoAlunos;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<AlunoCurso> getAlunoCursos() {
		return this.alunoCursos;
	}

	public void setAlunoCursos(List<AlunoCurso> alunoCursos) {
		this.alunoCursos = alunoCursos;
	}

	public AlunoCurso addAlunoCurso(AlunoCurso alunoCurso) {
		getAlunoCursos().add(alunoCurso);
		alunoCurso.setUsuario(this);

		return alunoCurso;
	}

	public AlunoCurso removeAlunoCurso(AlunoCurso alunoCurso) {
		getAlunoCursos().remove(alunoCurso);
		alunoCurso.setUsuario(null);

		return alunoCurso;
	}

	public List<DisciplinaProfessor> getDisciplinaProfessors() {
		return this.disciplinaProfessors;
	}

	public void setDisciplinaProfessors(List<DisciplinaProfessor> disciplinaProfessors) {
		this.disciplinaProfessors = disciplinaProfessors;
	}

	public DisciplinaProfessor addDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		getDisciplinaProfessors().add(disciplinaProfessor);
		disciplinaProfessor.setUsuario(this);

		return disciplinaProfessor;
	}

	public DisciplinaProfessor removeDisciplinaProfessor(DisciplinaProfessor disciplinaProfessor) {
		getDisciplinaProfessors().remove(disciplinaProfessor);
		disciplinaProfessor.setUsuario(null);

		return disciplinaProfessor;
	}

	public List<TrabalhoAluno> getTrabalhoAlunos() {
		return this.trabalhoAlunos;
	}

	public void setTrabalhoAlunos(List<TrabalhoAluno> trabalhoAlunos) {
		this.trabalhoAlunos = trabalhoAlunos;
	}

	public TrabalhoAluno addTrabalhoAluno(TrabalhoAluno trabalhoAluno) {
		getTrabalhoAlunos().add(trabalhoAluno);
		trabalhoAluno.setUsuario(this);

		return trabalhoAluno;
	}

	public TrabalhoAluno removeTrabalhoAluno(TrabalhoAluno trabalhoAluno) {
		getTrabalhoAlunos().remove(trabalhoAluno);
		trabalhoAluno.setUsuario(null);

		return trabalhoAluno;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}