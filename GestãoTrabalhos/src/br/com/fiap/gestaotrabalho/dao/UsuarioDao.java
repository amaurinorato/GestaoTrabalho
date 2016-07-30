package br.com.fiap.gestaotrabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.Usuario;

public class UsuarioDao extends GenericDao<Usuario>{

	public UsuarioDao() {
		super(Usuario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarProfessores() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "PROFESSOR");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarAlunos() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "ALUNO");
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarAdministradores() {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("from Usuario u where u.role.nome like :nome");
		q.setParameter("nome", "ADMIN");
		return q.getResultList();
	}
	
	

}
