import java.util.ArrayList;

public class Materia {
	
	private String nome;
	private int codigo;
	private int creditos;
	private String sala;
	private ArrayList<Aluno> alunosCadastrados;
	private String horario;
	
	
	


	public Materia(String nome, int codigo, int creditos, String sala,String horario) {
		this.nome = nome;
		this.codigo = codigo;
		this.creditos = creditos;
		this.sala = sala;
		this.horario = horario;
		alunosCadastrados = new ArrayList<Aluno>();
		
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


	public ArrayList<Aluno> getAlunosCadastrados() {
		return alunosCadastrados;
	}


	public void setAlunosCadastrados(ArrayList<Aluno> alunosCadastrados) {
		this.alunosCadastrados = alunosCadastrados;
	}


	public String getHorario() {
		return horario;
	}


	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public boolean removerAlunosCadastrados(Aluno a) {
		return alunosCadastrados.remove(a);
	}
	
	public boolean adcionarAlunosCadastrados(Aluno a) {
		return alunosCadastrados.add(a);
	}


	@Override
	public String toString() {
		return "Materia [nome=" + nome + ", codigo=" + codigo + ", creditos=" + creditos + ", sala=" + sala
				+ ", alunosCadastrados=" + alunosCadastrados.toString() + ", horario=" + horario + "]";
	}


	
	

}
