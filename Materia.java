import java.util.ArrayList;

public class Materia {
	
	private String nome;
	private int codigo;
	private int creditos;
	private String sala;
	private ArrayList<AlunoMateria> alunosCadastrados;
	private String horario;

	

	public Materia(String nome, int codigo, int creditos, String sala,String horario) {
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.sala = sala;
		this.horario = horario;
		alunosCadastrados = new ArrayList<AlunoMateria>();
		
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
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
	
	public boolean removerAlunosCadastrados(AlunoMateria a) {
		return alunosCadastrados.remove(a);
	}
	
	public boolean adcionarAlunosCadastrados(AlunoMateria am) {
		return alunosCadastrados.add(am);
	}


	@Override
	public String toString() {
		
		String out = "Alunos cadastrados em " + getNome() + ":\n";
		for(AlunoMateria am: alunosCadastrados) {
			
			out += "* " + am.getAluno().getRA() + " - ";
			out += am.getAluno().getNome() + "\n";
		}
	return out;
	}


	
	

}
