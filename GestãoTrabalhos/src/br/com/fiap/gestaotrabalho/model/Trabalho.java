package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the trabalho database table.
 * 
 */
@Entity
@NamedQuery(name="Trabalho.findAll", query="SELECT t FROM Trabalho t")
public class Trabalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_trabalho")
	private int idTrabalho;

	private String descricao;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="id_disciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to TrabalhoAluno
	@OneToMany(mappedBy="trabalho")
	private List<TrabalhoAluno> trabalhoAlunos;

	public Trabalho() {
	}

	public int getIdTrabalho() {
		return this.idTrabalho;
	}

	public void setIdTrabalho(int idTrabalho) {
		this.idTrabalho = idTrabalho;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<TrabalhoAluno> getTrabalhoAlunos() {
		return this.trabalhoAlunos;
	}

	public void setTrabalhoAlunos(List<TrabalhoAluno> trabalhoAlunos) {
		this.trabalhoAlunos = trabalhoAlunos;
	}

	public TrabalhoAluno addTrabalhoAluno(TrabalhoAluno trabalhoAluno) {
		getTrabalhoAlunos().add(trabalhoAluno);
		trabalhoAluno.setTrabalho(this);

		return trabalhoAluno;
	}

	public TrabalhoAluno removeTrabalhoAluno(TrabalhoAluno trabalhoAluno) {
		getTrabalhoAlunos().remove(trabalhoAluno);
		trabalhoAluno.setTrabalho(null);

		return trabalhoAluno;
	}

}