package br.com.gestatotrabalho.professor.test;

import java.util.List;

import br.com.fiap.gestaotrabalho.dao.UsuarioDao;
import br.com.fiap.gestaotrabalho.model.Usuario;

public class ProfessorTest {
	
	public static void main(String[] args) {
		UsuarioDao u = new UsuarioDao();
		List<Usuario> alunos = u.listarAlunos();
		List<Usuario>  professores = u.listarProfessores();
		List<Usuario>  admins = u.listarAdministradores();
		
		System.out.println(alunos.size());
		System.out.println(professores.size());
		System.out.println(admins.size());
		
		
		
	}

}
