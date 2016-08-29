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
	
	private Integer peso;
	
	private String nome;

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

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idTrabalho;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((trabalhoAlunos == null) ? 0 : trabalhoAlunos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trabalho other = (Trabalho) obj;
		if (idTrabalho != other.idTrabalho)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		return true;
	}
}