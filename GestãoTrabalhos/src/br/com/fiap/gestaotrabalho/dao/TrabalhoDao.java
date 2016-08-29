package br.com.fiap.gestaotrabalho.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.gestaotrabalho.model.Disciplina;
import br.com.fiap.gestaotrabalho.model.Trabalho;
import br.com.fiap.gestaotrabalho.model.TrabalhoAluno;
import br.com.fiap.gestaotrabalho.model.Usuario;

public class TrabalhoDao {
	
	List<Trabalho> trabalhos;
	
	@SuppressWarnings("unchecked")
	public List<Trabalho> listarTrabalhosPorDisciplina(Disciplina disciplina, Usuario professor) {
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select t from Trabalho t "
				+ " inner join t.disciplina d " 
				+ " inner join d.disciplinaProfessors dp "
				+ " where t.disciplina.idDisciplina = :idDisciplina "
				+ " and dp.usuario.idUsuario = :idUsuario");
		q.setParameter("idDisciplina", disciplina.getIdDisciplina());
		q.setParameter("idUsuario", professor.getIdUsuario());
		trabalhos = q.getResultList();
		em.close();
		return trabalhos;
	}
	
	@SuppressWarnings("unchecked")
	public List<TrabalhoAluno> listarTrabalhosPorCursoPorAlunoPorDisciplina(Integer idCurso, Integer idAluno, Integer idDiscplina) {
		List<TrabalhoAluno> trabalhosAluno = new ArrayList<TrabalhoAluno>();
		EntityManager em = JpaUtil.getEntityManager();
		em = JpaUtil.getEntityManager();
		Query q = em.createQuery("Select t from TrabalhoAluno t "
				+ " inner join t.trabalho tr "
				+ " inner join tr.disciplina d "
				+ " inner join d.cursoDisciplinas cd "
				+ " inner join cd.curso c" 
				+ " where c.idCurso = :idCurso "
				+ " and t.usuario.idUsuario = :idUsuario"
				+ " nad d.idDicplina = :idDisciplina ");
		q.setParameter("idCurso", idCurso);
		q.setParameter("idUsuario", idAluno);
		q.setParameter("idDiscplina", idDiscplina);
		trabalhos = q.getResultList();
		em.close();
		return trabalhosAluno;
	}

}
