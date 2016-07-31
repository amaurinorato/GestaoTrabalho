package br.com.fiap.gestaotrabalho.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	

}
