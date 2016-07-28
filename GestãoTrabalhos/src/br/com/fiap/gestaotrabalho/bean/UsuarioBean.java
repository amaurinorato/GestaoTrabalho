package br.com.fiap.gestaotrabalho.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.gestaotrabalho.model.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
