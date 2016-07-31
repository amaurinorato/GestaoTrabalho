package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.gestaotrabalho.dao.CursoDao;
import br.com.fiap.gestaotrabalho.dao.Dao;
import br.com.fiap.gestaotrabalho.dao.DisciplinaDao;
import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.Trabalho;
import br.com.fiap.gestaotrabalho.model.Usuario;

@ViewScoped
@ManagedBean
public class TrabalhoBean implements Serializable {

	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	private Curso curso;
	private Trabalho trabalho;


	public TrabalhoBean() {
		trabalho = new Trabalho();
	}

	public void salvarTrabalho() {
		try {
			Dao<Trabalho> tDao = new GenericDao<Trabalho>(Trabalho.class);
			tDao.adicionar(trabalho);
			trabalho = new Trabalho();
			curso = new Curso();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Trabalho salvo com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro ao salvar o trabalho. Tente novamente!"));
		}
	}
	
	public List<Curso> getCursos() {
		if(cursos == null || cursos.size() <= 0) {
			CursoDao dao = new CursoDao();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			cursos = dao.recuperarCursosPorProfessor((Usuario)session.getAttribute("usuario_sessao"));
		}
		return cursos;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Disciplina> getDisciplinas() {
		if(curso != null && (disciplinas == null || disciplinas.size() <= 0)) {
			DisciplinaDao dDao = new DisciplinaDao();
			disciplinas = dDao.recuperarDisciplinasDoCurso(curso);
		}
		return disciplinas;
	}
	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}


}
