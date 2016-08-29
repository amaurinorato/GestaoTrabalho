package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;

import br.com.fiap.gestaotrabalho.dao.CursoDao;
import br.com.fiap.gestaotrabalho.dao.Dao;
import br.com.fiap.gestaotrabalho.dao.DisciplinaDao;
import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.dao.TrabalhoDao;
import br.com.fiap.gestaotrabalho.dao.UsuarioDao;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.Trabalho;
import br.com.fiap.gestaotrabalho.model.TrabalhoAluno;
import br.com.fiap.gestaotrabalho.model.Usuario;

@ViewScoped
@ManagedBean
public class TrabalhoBean implements Serializable {

	private List<Curso> cursos;
	private List<Disciplina> disciplinas;
	private Curso curso;
	private Trabalho trabalho;
	private List<Usuario> alunos;
	private Usuario aluno;
	private TrabalhoAluno trabalhoAluno;
	private List<Trabalho> trabalhos;

	public TrabalhoBean() {
		trabalho = new Trabalho();
		trabalhoAluno = new TrabalhoAluno();
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
	
	public void corrigirTrabalho() {
		try {
			Dao<TrabalhoAluno> tDao = new GenericDao<TrabalhoAluno>(TrabalhoAluno.class);
			tDao.adicionar(trabalhoAluno);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Trabalho corrigido com sucesso!"));
		} catch (Exception e) {
			if (e.getCause().getClass().equals(ConstraintViolationException.class)) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Nota Já cadastrada para o trablho e o aluno selecionado!!"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro ao corrigir o trabalho. Tente novamente!"));
			}
		} 
		trabalho = new Trabalho();
		curso = new Curso();
		trabalhoAluno = new TrabalhoAluno();
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
		if(curso != null) {
			DisciplinaDao dDao = new DisciplinaDao();
			disciplinas = dDao.recuperarDisciplinasDoCurso(curso);
		}
		return disciplinas;
	}
	
	public List<Usuario> getAlunos() {
		if(trabalhoAluno.getTrabalho() != null) {
			UsuarioDao dDao = new UsuarioDao();
			alunos = dDao.listarAlunosPorCurso(curso);
		}
		return alunos;
	}
	public Trabalho getTrabalho() {
		return trabalho;
	}

	public void setTrabalho(Trabalho trabalho) {
		this.trabalho = trabalho;
	}

	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public TrabalhoAluno getTrabalhoAluno() {
		return trabalhoAluno;
	}

	public void setTrabalhoAluno(TrabalhoAluno trabalhoAluno) {
		this.trabalhoAluno = trabalhoAluno;
	}
	
	public List<Trabalho> getTrabalhos() {
		if (trabalho.getDisciplina() != null) {
			TrabalhoDao tDao = new TrabalhoDao();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			Usuario u = (Usuario) session.getAttribute("usuario_sessao");
			trabalhos = tDao.listarTrabalhosPorDisciplina(trabalho.getDisciplina(), u);
		}
		return trabalhos;
	}
}