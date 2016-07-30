package br.com.fiap.gestaotrabalho.bean;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
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

	public void salvarEscola() {
		try {
			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
			dao.adicionar(escola);
			escola = new Escola();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Escola salva com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro ao salvar a escola. Tente novamente!"));
		}
	}


}
