public abstract class Pessoa {
	
	private String 	   nome;
	private int        idade;
	private char       sexo;
	private String 	   dataNascimento;
	private int RA;
	private String 	   senha;
	private static int numPessoas = 0;
	
	
	public Pessoa
	(String nome, int idade, char sexo, String dataNascimento, String senha) {
		
		this.nome  = nome;
		this.idade = idade;
		this.sexo  = sexo;
		this.dataNascimento = dataNascimento;
		this.RA    = ++numPessoas;
		this.senha = senha;		// senha do sistema; login: o RA da pessoa
	}
	
	@Override
	public String toString() {
		return nome + " | RA: " + RA + " | Idade: " + idade + " | Sexo: " + sexo + "\n";
				
	}
	
	public void setRA(int rA) {
		RA = rA;
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
	public long getRA() {
		return RA;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
 
}
