package br.com.fiap.gestaotrabalho.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.fiap.gestaotrabalho.model.Curso;

@ManagedBean
@ViewScoped
public class AlunoBean implements Serializable {

	private List<Curso> cursosAluno;
	
	public AlunoBean() {
	}

	public List<Curso> getCursosAluno() {
		if (cursosAluno == null && cursosAluno.size() <= 0) {
			
		}
		return cursosAluno;
	}
}
