package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.gestaotrabalho.dao.CursoDao;
import br.com.fiap.gestaotrabalho.dao.DisciplinaDao;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Usuario;
import br.com.fiap.gestaotrabalho.vo.DisciplinaVO;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private List<Curso> cursosAluno;
	private List<DisciplinaVO> disciplinas;
 	
	public AlunoBean() {
	}

	public List<Curso> getCursosAluno() {
		if (cursosAluno == null || cursosAluno.size() <= 0) {
			CursoDao cdao = new CursoDao();
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			cursosAluno = cdao.recuperarCursosPorAluno((Usuario)session.getAttribute("usuario_sessao"));
		}
		return cursosAluno;
	}
	
	public void verPorDisciplina(Integer idCurso) {
		DisciplinaDao dDao = new DisciplinaDao();
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		disciplinas = dDao.recuperarDisciplinasPorAlunoPorCurso(((Usuario)session.getAttribute("usuario_sessao")).getIdUsuario(), idCurso);
	}

	public List<DisciplinaVO> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaVO> disciplinas) {
		this.disciplinas = disciplinas;
	}
}
