package projeto_MC302;

import java.util.ArrayList;

public class Aluno extends Pessoa{
	
	private ArrayList<Materia> materias;
	private int serie;
	private boolean tutoria;
	private int advertencias;
	private String periodo;
	private ArrayList<Integer> notas;
	
	public Aluno() {
		
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public boolean isTutoria() {
		return tutoria;
	}

	public void setTutoria(boolean tutoria) {
		this.tutoria = tutoria;
	}

	public int getAdvertencias() {
		return advertencias;
	}

	public void setAdvertencias(int advertencias) {
		this.advertencias = advertencias;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public ArrayList<Integer> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}
	
	

}
