
public class Pessoa {
	
	private String nome;
	private int idade;
	private char sexo;
	private String dataNascimento;
	private final String RA;
	private String senha;
	
	
	public Pessoa(String nome,int idade,char sexo,String dataNascimento,String RA,String senha) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.RA = RA;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRA() {
		return RA;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento
				+ ", RA=" + RA + ", senha=" + senha + "]";
	}
	
	
	
}
