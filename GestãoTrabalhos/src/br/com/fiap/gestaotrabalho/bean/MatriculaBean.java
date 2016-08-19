package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.exception.ConstraintViolationException;

import br.com.fiap.gestaotrabalho.dao.GenericDao;
import br.com.fiap.gestaotrabalho.dao.UsuarioDao;
import br.com.fiap.gestaotrabalho.model.AlunoCurso;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Usuario;

@javax.faces.bean.ManagedBean
@ViewScoped
public class MatriculaBean implements Serializable {
	
	private AlunoCurso matricula;
	
	public MatriculaBean(){
		matricula = new AlunoCurso();
	}
	
	public void efetuarMatricula() {
		try {
			GenericDao<AlunoCurso> acDao = new GenericDao<AlunoCurso>(AlunoCurso.class);
			acDao.adicionar(matricula);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Matrícula efetuada com sucesso!"));
		} catch (ConstraintViolationException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "O aluno selecionada já está cadastrado no curso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Ocorreu um erro ao efetuar a matrícula. Tente novamente!"));
		}
		matricula = new AlunoCurso();
	}

	public AlunoCurso getMatricula() {
		return matricula;
	}

	public void setMatricula(AlunoCurso matricula) {
		this.matricula = matricula;
	}

	public List<Curso> getCursos() {
		GenericDao<Curso> cDao = new GenericDao<Curso>(Curso.class);
		return cDao.listar();
	}

	public List<Usuario> getAlunos() {
		UsuarioDao uDao = new UsuarioDao();
		return uDao.listarAlunos();
	}
}
