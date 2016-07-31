package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.dao.UsuarioDao;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.DisciplinaProfessor;
import br.com.fiap.gestaotrabalho.model.Usuario;

@ManagedBean
@RequestScoped
public class DisciplinaBean implements Serializable {

	private Disciplina disciplina = new Disciplina();
	
	private List<Usuario> professores;
	private List<Usuario> selectedProfessores;

	
	public void salvarDisciplina() {
		try {
			GenericDao<Disciplina> disciplinaDao = new GenericDao<Disciplina>(Disciplina.class);
			List<DisciplinaProfessor> disciplinasProfessores = new ArrayList<DisciplinaProfessor>();
			for (Usuario usuario : selectedProfessores) {
				DisciplinaProfessor disciplinaProfessor = new DisciplinaProfessor();
				disciplinaProfessor.setDisciplina(disciplina);
				disciplinaProfessor.setUsuario(usuario);
				disciplinasProfessores.add(disciplinaProfessor);
			}
			disciplina.setDisciplinaProfessors(disciplinasProfessores);
			disciplinaDao.adicionar(disciplina);
			disciplina = new Disciplina();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Disciplina salva com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Erro ao salvar a disciplina!"));
			
		}
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
