package br.com.fiap.gestaotrabalho.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("gestaoTrabalhoPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
