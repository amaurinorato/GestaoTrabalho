package br.com.fiap.gestaotrabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Usuario;

public class CursoDao extends GenericDao<Curso> {

	List<Curso> cursos;
	
	public CursoDao() {
		super(Curso.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> recuperarCursosPorProfessor(Usuario professor) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select c.curso from CursoDisciplina c INNER JOIN c.disciplina d "
				+ "INNER JOIN d.disciplinaProfessors dp where dp.usuario.idUsuario = :idUsuario");
		q.setParameter("idUsuario", professor.getIdUsuario());
		cursos = q.getResultList();
		em.close();
		return cursos;
	}
	
	@SuppressWarnings("unchecked")
	public List<Curso> recuperarCursosPorAluno(Usuario aluno) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select c from Curso c INNER JOIN c.alunoCursos ac "
				+ "INNER JOIN ac.aluno a where ac.aluno.idUsuario = :idUsuario");
		q.setParameter("idUsuario", aluno.getIdUsuario());
		cursos = q.getResultList();
		em.close();
		return cursos;
	}
	
}
