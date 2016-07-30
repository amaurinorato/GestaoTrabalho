package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the escola database table.
 * 
 */
@Entity
@NamedQuery(name="Escola.findAll", query="SELECT e FROM Escola e")
public class Escola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_escola")
	private int idEscola;

	private String complemento;

	private String endereco;

	private String nome;

	private String numero;
	
	private String cep;

	//bi-directional many-to-one association to CursoEscola
	@OneToMany(mappedBy="escola")
	private List<CursoEscola> cursoEscolas;

	public Escola() {
	}

	public int getIdEscola() {
		return this.idEscola;
	}

	public void setIdEscola(int idEscola) {
		this.idEscola = idEscola;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<CursoEscola> getCursoEscolas() {
		return this.cursoEscolas;
	}

	public void setCursoEscolas(List<CursoEscola> cursoEscolas) {
		this.cursoEscolas = cursoEscolas;
	}

	public CursoEscola addCursoEscola(CursoEscola cursoEscola) {
		getCursoEscolas().add(cursoEscola);
		cursoEscola.setEscola(this);

		return cursoEscola;
	}

	public CursoEscola removeCursoEscola(CursoEscola cursoEscola) {
		getCursoEscolas().remove(cursoEscola);
		cursoEscola.setEscola(null);

		return cursoEscola;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cursoEscolas == null) ? 0 : cursoEscolas.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + idEscola;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Escola other = (Escola) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (idEscola != other.idEscola)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
}