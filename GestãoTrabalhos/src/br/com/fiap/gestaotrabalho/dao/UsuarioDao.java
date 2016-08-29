package br.com.fiap.gestaotrabalho.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.AlunoCurso;
import br.com.fiap.gestaotrabalho.model.Curso;
import br.com.fiap.gestaotrabalho.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario>{

	List<Usuario> usuarios;
	public UsuarioDao() {
		super(Usuario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarProfessores() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "PROFESSOR");
		usuarios = q.getResultList();
		em.close();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarAlunos() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "ALUNO");
		usuarios = q.getResultList();
		em.close();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarAdministradores() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "ADMIN");
		usuarios = q.getResultList();
		em.close();
		return usuarios;
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarAlunosPorCurso(Curso curso) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from AlunoCurso u where u.curso.idCurso = :idCurso");
		q.setParameter("idCurso", curso.getIdCurso());
		List<AlunoCurso> alunosCurso = q.getResultList();
		if (usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}
		for (AlunoCurso alunoCurso : alunosCurso) {
			usuarios.add(alunoCurso.getAluno());
		}
		em.close();
		return usuarios;
	}
}
