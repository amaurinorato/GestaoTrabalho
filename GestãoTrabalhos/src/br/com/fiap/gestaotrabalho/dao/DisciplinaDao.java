package br.com.fiap.gestaotrabalho.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.TrabalhoAluno;
import br.com.fiap.gestaotrabalho.vo.DisciplinaVO;

public class DisciplinaDao extends GenericDao<Disciplina> {
	
	List<Disciplina> disciplinas;
	
	public DisciplinaDao() {
		super(Disciplina.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> recuperarDisciplinasDoCurso(Curso curso) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select c.disciplina from CursoDisciplina c where c.curso.idCurso = :idCurso");
		q.setParameter("idCurso", curso.getIdCurso());
		disciplinas = q.getResultList();
		em.close();
		return disciplinas;
	}
	
	@SuppressWarnings("unchecked")
	public List<DisciplinaVO> recuperarDisciplinasPorAlunoPorCurso(Integer idAluno, Integer idCurso) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select c.disciplina from CursoDisciplina c "
				+ " INNER JOIN c.curso cu "
				+ " INNER JOIN cu.alunoCursos ac"
				+ " where c.curso.idCurso = :idCurso"
				+ " and ac.aluno.idUsuario = :idAluno");
		q.setParameter("idCurso", idCurso);
		q.setParameter("idAluno", idAluno);
		disciplinas = q.getResultList();
		List<DisciplinaVO> disciplinasVO = new ArrayList<DisciplinaVO>();
		for (Disciplina disciplina : disciplinas) {
			TrabalhoDao tDao = new TrabalhoDao();
			List<TrabalhoAluno> trabalhosAluno = tDao.listarTrabalhosPorCursoPorAlunoPorDisciplina(idCurso, idAluno, disciplina.getIdDisciplina());
			for (TrabalhoAluno trabalhoAluno : trabalhosAluno) {
				DisciplinaVO disciplinaVO = new DisciplinaVO();
				disciplinaVO.setNome(trabalhoAluno.getTrabalho().getDisciplina().getNome());
				disciplinaVO.setTrabalhos(trabalhosAluno);
				disciplinaVO.setNotaFinal(calcularNotaFinal(trabalhosAluno));
				disciplinaVO.setStatus(disciplinaVO.getNotaFinal() >= 7 ? "APROVADO" : "REPROVADO");
				disciplinasVO.add(disciplinaVO);
			}
		}
		return disciplinasVO;
	}

	private double calcularNotaFinal(List<TrabalhoAluno> trabalhosAluno) {
		double nota = 0;
		for (TrabalhoAluno trabalhoAluno : trabalhosAluno) {
			nota += trabalhoAluno.getNota() * (trabalhoAluno.getTrabalho().getPeso() /100);
		}
		return nota;
	}
}
