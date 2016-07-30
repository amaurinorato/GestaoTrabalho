package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.dao.UsuarioDao;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.Usuario;

@ManagedBean
@RequestScoped
public class DisciplinaBean implements Serializable {

	private Disciplina disciplina = new Disciplina();
	
	private List<Usuario> professores;
	private List<Usuario> selectedProfessores;

	
	public void salvarDisciplina() {
		GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
		dao.adicionar(disciplina);
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Usuario> getSelectedProfessores() {
		return selectedProfessores;
	}

	public void setSelectedProfessores(List<Usuario> selectedProfessores) {
		this.selectedProfessores = selectedProfessores;
	}

	public List<Usuario> getProfessores() {
		if(professores == null || professores.size() == 0) {
			UsuarioDao dao = new UsuarioDao();
			professores = dao.listarProfessores();
		}
		return professores;
	}
}
