package br.com.fiap.gestaotrabalho.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_curso")
	private int idCurso;

	@Column(name="carga_horaria")
	private Integer cargaHoraria;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio")
	private Date dtInicio;

	@Column(name="nome_curso")
	private String nomeCurso;

	//bi-directional many-to-one association to AlunoCurso
	@OneToMany(mappedBy="curso")
	private List<AlunoCurso> alunoCursos;

	//bi-directional many-to-one association to CursoDisciplina
	@OneToMany(mappedBy="curso", cascade=CascadeType.ALL)
	private List<CursoDisciplina> cursoDisciplinas;

	//bi-directional many-to-one association to CursoEscola
	@OneToMany(mappedBy="curso", cascade=CascadeType.ALL)
	private List<CursoEscola> cursoEscolas;

	public Curso() {
	}
	
	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<AlunoCurso> getAlunoCursos() {
		return this.alunoCursos;
	}

	public void setAlunoCursos(List<AlunoCurso> alunoCursos) {
		this.alunoCursos = alunoCursos;
	}

	public AlunoCurso addAlunoCurso(AlunoCurso alunoCurso) {
		getAlunoCursos().add(alunoCurso);
		alunoCurso.setCurso(this);

		return alunoCurso;
	}

	public AlunoCurso removeAlunoCurso(AlunoCurso alunoCurso) {
		getAlunoCursos().remove(alunoCurso);
		alunoCurso.setCurso(null);

		return alunoCurso;
	}

	public List<CursoDisciplina> getCursoDisciplinas() {
		return this.cursoDisciplinas;
	}

	public void setCursoDisciplinas(List<CursoDisciplina> cursoDisciplinas) {
		this.cursoDisciplinas = cursoDisciplinas;
	}

	public CursoDisciplina addCursoDisciplina(CursoDisciplina cursoDisciplina) {
		getCursoDisciplinas().add(cursoDisciplina);
		cursoDisciplina.setCurso(this);

		return cursoDisciplina;
	}

	public CursoDisciplina removeCursoDisciplina(CursoDisciplina cursoDisciplina) {
		getCursoDisciplinas().remove(cursoDisciplina);
		cursoDisciplina.setCurso(null);

		return cursoDisciplina;
	}

	public List<CursoEscola> getCursoEscolas() {
		return this.cursoEscolas;
	}

	public void setCursoEscolas(List<CursoEscola> cursoEscolas) {
		this.cursoEscolas = cursoEscolas;
	}

	public CursoEscola addCursoEscola(CursoEscola cursoEscola) {
		getCursoEscolas().add(cursoEscola);
		cursoEscola.setCurso(this);

		return cursoEscola;
	}

	public CursoEscola removeCursoEscola(CursoEscola cursoEscola) {
		getCursoEscolas().remove(cursoEscola);
		cursoEscola.setCurso(null);

		return cursoEscola;
	}

}