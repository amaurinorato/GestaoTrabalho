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
	private int idEscola;

	private String complemento;

	private String endereço;

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

	public String getEndereço() {
		return this.endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
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
}