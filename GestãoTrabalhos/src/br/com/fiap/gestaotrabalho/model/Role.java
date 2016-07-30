package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_Role;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="role")
	private List<Usuario> usuarios;
	
	public Role() {
	}

	public int getId_Role() {
		return this.id_Role;
	}

	public void setId_Role(int id_Role) {
		this.id_Role = id_Role;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRole(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRole(null);

		return usuario;
	}
	
	public boolean getAdmin() {
		return this.nome.equalsIgnoreCase("ADMIN");
	}
	
	public boolean getProfessor() {
		return this.nome.equalsIgnoreCase("PROFESSOR");
	}
	
	public boolean getAluno() {
		return this.nome.equalsIgnoreCase("ALUNO");
	}

}