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
	private int capacidadeMax;
	private int capacidadeAtual;
	

	public Materia
	(String nome, String codigo, int creditos, String sala,String horario, Dia dia, int capacidade) {
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.sala = sala;
		this.horario = horario;
		this.dia = dia;
		this.capacidadeMax = capacidade;
		capacidadeAtual = 0;
		alunosCadastrados = new ArrayList<AlunoMateria>();
	}

	public boolean removerAlunosCadastrados(AlunoMateria am) {
		return alunosCadastrados.remove(am);
	}
	
	public boolean adicionarAlunosCadastrados(AlunoMateria am) {
		capacidadeAtual++;
		return alunosCadastrados.add(am);
	}

	@Override
	public String toString() {
		
		String out = "==) Materia " + nome + " (cod. " + codigo + ") | ";
		out += " Creditos: " + creditos + " | " + "Professor: ";
		
		if (professor == null)
			out += "VAGO\n";
		else
			out += professor.getNome() + "\n";
		
		out += "    Dia: " + dia + " | Horario: " + horario + " | Sala: " + sala + "\n";
		out += "    Alunos cadastrados: ";
		
		for(AlunoMateria am: alunosCadastrados) {
			
			out += "* " + am.getAluno().getNome() + " (RA: " + am.getAluno().getRA() + ")  ";
		}
		
		return out;
	}
	
	public int getCapacidadeAtual() {
		return capacidadeAtual;
	}

	public void setCapacidadeAtual(int capacidadeAtual) {
		this.capacidadeAtual = capacidadeAtual;
	}

	public int getCapacidadeMax() {
		return capacidadeMax;
	}


	public void setCapacidadeMax(int capacidade) {
		this.capacidadeMax = capacidade;
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

}