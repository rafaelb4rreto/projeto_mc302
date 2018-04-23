import java.util.ArrayList;

public class Materia {
	
	private String nome;
	private String codigo;
	private int creditos;
	private String sala;
	private ArrayList<AlunoMateria> alunosCadastrados;
	private String horario;
	private Professor professor;
	private Dia dia;

	

	public Materia(String nome, String codigo, int creditos, String sala,String horario, Dia dia) {
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.sala = sala;
		this.horario = horario;
		this.dia = dia;
		alunosCadastrados = new ArrayList<AlunoMateria>();
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public int getCreditos() {
		return creditos;
	}


	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public String getSala() {
		return sala;
	}


	public void setSala(String sala) {
		this.sala = sala;
	}


	public ArrayList<AlunoMateria> getAlunosCadastrados() {
		return alunosCadastrados;
	}


	public void setAlunosCadastrados(ArrayList<AlunoMateria> alunosCadastrados) {
		this.alunosCadastrados = alunosCadastrados;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}


	public boolean removerAlunosCadastrados(AlunoMateria a) {
		return alunosCadastrados.remove(a);
	}
	
	public boolean adcionarAlunosCadastrados(AlunoMateria am) {
		return alunosCadastrados.add(am);
	}


	@Override
	public String toString() {
		
		String out = "Materia: " + getCodigo();
		out += " - " + getNome() + "\n";
		out += "Dia: " + getDia();
		out += "  Horario: " + getHorario();
		out += "  Sala: " + getSala() + "\n";
		out += "Numero de creditos: " + getCreditos() + "\n";
		out += "Professor responsavel: " + getProfessor().getNome() + "\n";
		out += "Alunos cadastrados em " + getNome() + ":\n";
		for(AlunoMateria am: alunosCadastrados) {
			
			out += "* " + am.getAluno().getRA() + " - ";
			out += am.getAluno().getNome() + "\n";
		}
	return out;
	}


	
	

}
