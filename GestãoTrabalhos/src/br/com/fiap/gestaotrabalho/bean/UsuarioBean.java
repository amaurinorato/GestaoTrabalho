package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.management.relation.Role;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public List<Usuario> getUsuarios() {
		GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
		return dao.listar();
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioBean () {
		usuario = new Usuario();
	}

	public String validarUsuario() {
		try {
			GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
			usuario = dao.buscar(usuario.getMatricula(), usuario.getSenha());
			if(usuario != null){
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario_sessao", usuario);
				return "/pages/welcome";
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário e/ou Senha Inválidos!"));
			}
		} catch (NoResultException nre) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário e/ou Senha Inválidos!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro. Tente novamente!"));
		} 
		return "login";
	}
	
	public String sair() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		return "/login.xhtml";
	}
	
	public void salvarUsuario() {
		try {
			GenericDao<Usuario> usuarioDao = new GenericDao<Usuario>(Usuario.class);
			usuario.setCpf(usuario.getCpf().replace(".", "").replace("-", ""));
			usuarioDao.adicionar(usuario);
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário salvo com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar o usuário!"));
		}
	}
	
	public List<Role> getRoles() {
		GenericDao<Role> roleDao = new GenericDao<Role>(Role.class);
		return roleDao.listar();
	}
}
