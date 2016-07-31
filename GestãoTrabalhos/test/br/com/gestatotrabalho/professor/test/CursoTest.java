package br.com.gestatotrabalho.professor.test;

import br.com.fiap.gestaotrabalho.dao.CursoDao;
import br.com.fiap.gestaotrabalho.dao.UsuarioDao;

public class CursoTest {
	
	public static void main(String[] args) {
		UsuarioDao ud = new UsuarioDao();
		
		CursoDao d = new CursoDao();
		System.out.println(d.recuperarCursosPorProfessor(ud.listarProfessores().get(0)).size());
	}

}
