package projeto_MC302;

import java.util.ArrayList;

public class Materia {

	private String nome;
	private String sala;
	private ArrayList<Aluno> alunosCadastrados;
	private Dia dia;
	private String horario;
	
	public Materia() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public ArrayList<Aluno> getAlunosCadastrados() {
		return alunosCadastrados;
	}

	public void setAlunosCadastrados(ArrayList<Aluno> alunosCadastrados) {
		this.alunosCadastrados = alunosCadastrados;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
}
