package br.com.fiap.gestaotrabalho.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.gestaotrabalho.model.Escola;

@ManagedBean
@RequestScoped
public class EscolaBean {

	private Escola escola = new Escola();

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public EscolaBean() {
		super();
	}
	
	
}
