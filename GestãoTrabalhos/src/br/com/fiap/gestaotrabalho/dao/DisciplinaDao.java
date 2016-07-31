package br.com.fiap.gestaotrabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Disciplina;

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
}
