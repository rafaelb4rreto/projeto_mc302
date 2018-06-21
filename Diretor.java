import java.util.ArrayList;

public class Diretor extends Pessoa{
	
	private int salario;
	private ArrayList<Aluno>	 alunos;
	private ArrayList<Materia> 	 materias; 
	private ArrayList<Professor> professores;
	
	public Diretor
	(String nome, int idade, char sexo, String dataNascimento, String RA, String senha, int salario) {
		super(nome, idade, sexo, dataNascimento, senha);
		
		this.salario = salario;
		
		alunos 		 = new ArrayList<Aluno>();
		materias 	 = new ArrayList<Materia>();
		professores  = new ArrayList<Professor>();
	}

	
	public Aluno matricularAluno(String nome, int idade, char sexo, String dataNascimento, String senha, int serie){
		Aluno novo_aluno = new Aluno (nome, idade, sexo, dataNascimento, senha, serie);
		alunos.add(novo_aluno);
		return novo_aluno;		
	}
	
	public boolean expulsarAluno(Aluno aluno){
		
		if (alunos.contains(aluno)){
			for (AlunoMateria ma: aluno.getMaterias()) {
				aluno.removerMateria(ma.getMateria());
			}
			
			alunos.remove(aluno);
			Aluno.setNumAlunos(Aluno.getNumAlunos()-1);
			
			return true;
			
		}else{
			
			return false;
		}
	}
	
	public Professor contratarProfessor(String nome, int idade, char sexo, String dataNascimento, String senha, String sala, int salario){
		Professor novo_professor = new Professor(nome, idade, sexo, dataNascimento, senha, sala, salario);
		professores.add(novo_professor);
		return novo_professor;
	}
	
	public boolean demitirProfessor(Professor prof){
		
		if (professores.contains(prof)) {
		
			for (Materia ma: prof.getMaterias()) {
				//prof.removerMateria(ma);						<< Opcao 1
				desatribuirMateriaAUmProfessor(prof, ma);	//	<< Opcao 2 (ver funcao abaixo)
			}
			
			professores.remove(prof);
			
			return true;
			
		}else{
			
			return false;
		}
	}	
	
	// praticamente todo o trabalho de se atribuir uma materia a um professor está
	// na funcao adicionarMateria() que está na classe professor!
	public boolean atribuirMateriaAUmProfessor(Professor prof, Materia materia){
		return prof.adicionarMateria(materia);
	}
	
	public boolean desatribuirMateriaAUmProfessor(Professor prof, Materia materia) {
		return prof.removerMateria(materia);
	}
	
	public Materia abrirMateria(String nome, String codigo, int creditos, String sala, String horario, Dia dia, int capacidade, String ementa){
		Materia nova_materia = new Materia(nome, codigo, creditos, sala, horario, dia, capacidade, ementa);
		materias.add(nova_materia);
		return nova_materia;
	}
	
	public void fecharMateria(Materia materia){

		/*for (int i = materia.getAlunosCadastrados().size()-1; i >= 0; i--) {
			materia.removerAlunosCadastrados(materia.getAlunosCadastrados().get(i));
		}*/
		materia.getAlunosCadastrados().removeAll(materia.getAlunosCadastrados());
		materia.setProfessor(null);
		materias.remove(materia);
	}
	
	public boolean enviarMensagem(String mensagem,Pessoa p) {
		if(p instanceof Professor) {
			System.out.println(mensagem);
			return true;
		}
		else if(p instanceof Aluno) {
			System.out.println(mensagem); //escreva no arquivo
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String out = super.toString();
		
		out = out +"\n    FUNCAO: Diretor | Salario: R$" + salario + "\n";
		return out;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	} 
	
	public void setBonus(Professor prof,int bonus) {
		prof.setSalario((bonus + prof.getSalario()));
	}
	
	public void setMaxCreditos(Aluno a,int valor) {
		a.setMaxCreditos(valor);
	}

	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
	}
	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}
	
}
