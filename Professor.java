package projeto_MC302;

import java.util.ArrayList;

public class Professor extends Pessoa{
	
	private int serie;
	private ArrayList<Materia> materias;
	private ArrayList<Aluno> tutorados;
	private String sala;
	private int salario;
	
	public Professor() {
		
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}

	public ArrayList<Aluno> getTutorados() {
		return tutorados;
	}

	public void setTutorados(ArrayList<Aluno> tutorados) {
		this.tutorados = tutorados;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	
	
}
