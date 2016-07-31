package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.CursoDisciplina;
import br.com.fiap.gestaotrabalho.model.CursoEscola;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.Escola;

@ManagedBean
@RequestScoped
public class CursoBean implements Serializable {
	
	private List<Escola> escolas;
	private List<Disciplina> disciplinas;
	
	private List<Disciplina> selectedDisciplinas = new ArrayList<Disciplina>();
	private List<Escola> selectedEscolas = new ArrayList<Escola>();
	private Curso curso;
	
	public CursoBean () {
		curso = new Curso();
	}
	
	public void salvarCurso() {
		try {
			GenericDao<Curso> dao = new GenericDao<Curso>(Curso.class);
			
			List<CursoDisciplina> cursosDisciplinas = new ArrayList<CursoDisciplina>();
			List<CursoEscola> cursosEscolas = new ArrayList<CursoEscola>();
			
			for (Disciplina disciplina : selectedDisciplinas) {
				CursoDisciplina cursoDisciplina = new CursoDisciplina();
				cursoDisciplina.setCurso(curso);
				cursoDisciplina.setDisciplina(disciplina);
				cursosDisciplinas.add(cursoDisciplina);
			}
			
			for (Escola escola : selectedEscolas) {
				CursoEscola cursoEscola = new CursoEscola();
				cursoEscola.setCurso(curso);
				cursoEscola.setEscola(escola);
				cursosEscolas.add(cursoEscola);
			}
			
			curso.setCursoDisciplinas(cursosDisciplinas);
			curso.setCursoEscolas(cursosEscolas);
			
			dao.adicionar(curso);
			curso = new Curso();
			selectedDisciplinas = new ArrayList<Disciplina>();
			selectedEscolas = new ArrayList<Escola>();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Curso Salvo com sucesso!"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro ao salvar o curso. Tente novamente!"));
		}
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Escola> getEscolas() {
		if(escolas == null || escolas.size() == 0) {
			GenericDao<Escola> dao = new GenericDao<Escola>(Escola.class);
			escolas = dao.listar();
		}
		return escolas;
	}

	public List<Escola> getSelectedEscolas() {
		return selectedEscolas;
	}

	public void setSelectedEscolas(List<Escola> selectedEscolas) {
		this.selectedEscolas = selectedEscolas;
	}

	public List<Disciplina> getSelectedDisciplinas() {
		return selectedDisciplinas;
	}

	public void setSelectedDisciplinas(List<Disciplina> selectedDisciplinas) {
		this.selectedDisciplinas = selectedDisciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		if(disciplinas == null || disciplinas.size() == 0) {
			GenericDao<Disciplina> dao = new GenericDao<Disciplina>(Disciplina.class);
			disciplinas = dao.listar();
		}
		return disciplinas;
	}
	
	
}
