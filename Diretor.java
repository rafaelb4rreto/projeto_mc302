import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Diretor extends Pessoa{
	
	private int salario;
	private int caixa;
	private ArrayList<Aluno>	 alunos;
	private ArrayList<Materia> 	 materias; 
	private ArrayList<Professor> professores;
	
	public Diretor
	(String nome, int idade, char sexo, String dataNascimento, String senha, int salario) {
		super(nome, idade, sexo, dataNascimento, senha);
		
		this.salario = salario;
		this.caixa = 0;
		alunos 		 = new ArrayList<Aluno>();
		materias 	 = new ArrayList<Materia>();
		professores  = new ArrayList<Professor>();
	}
	
	public void salvarDados() {
		
		Formatter output = null;
		try {
			output = new Formatter("src/escola.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		output.format("%s %d %c %s %s %d %d %d\n", getNome(), getIdade(), getSexo(), getDataNascimento(), getSenha(), getSalario(), getCaixa(), getRA());
		
		output.format("%d\n", alunos.size());
		for(int i=0; i<alunos.size(); i++) {
			alunos.get(i).salvarDados(output);
		}
		
		output.format("%d\n", professores.size());
		for(int i=0; i<professores.size(); i++) {
			professores.get(i).salvarDados(output);
		}
		
		output.format("%d\n", materias.size());
		for(int i=0; i<materias.size(); i++) {
			materias.get(i).salvarDados(output);
		}
		
		output.flush();
		output.close();	
	}
	
	public void carregarDados() {
		
		//Arquivo escola.txt dentro da pasta src do projeto
		String filename = "src/escola.txt";
		try {
			Scanner scan = new Scanner(new File(filename));
			Diretor d = new Diretor(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.nextInt());
			d.setCaixa(scan.nextInt());
			d.setRA(scan.nextInt());
			int temp = scan.nextInt();
			for(int i=0; i<temp;i++) {
				d.matricularAluno(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.nextInt());
				d.getAlunos().get(i).setRA(scan.nextInt());
				d.getAlunos().get(i).setAdvertencias(scan.nextInt());
				d.getAlunos().get(i).setSuspensoes(scan.nextInt());
				d.getAlunos().get(i).setMaxCreditos(scan.nextInt());
				d.getAlunos().get(i).setRegular(scan.nextBoolean());
				d.getAlunos().get(i).setBalanco(scan.nextInt());
				d.getAlunos().get(i).setMensalidade(scan.nextInt());
			}
			temp = scan.nextInt();
			for(int i=0; i<temp;i++) {
				d.contratarProfessor(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.next(), scan.nextInt());
				d.getProfessores().get(i).setRA(scan.nextInt());
				d.getProfessores().get(i).setPago(scan.nextBoolean());
			}
			temp = scan.nextInt();	//qtd de materias
			for(int i=0; i<temp;i++) {
				d.abrirMateria(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.next(), Dia.valueOf(scan.next()), scan.nextInt(), scan.nextLine());
				int tempRA = scan.nextInt();
				for(int j=0;j<d.getProfessores().size();j++) {
						
					if(d.getProfessores().get(j).getRA() == tempRA) {
						d.atribuirMateriaAUmProfessor(d.getProfessores().get(j), d.getMaterias().get(i));
					}
				}
				int qtdDeAlunos = scan.nextInt();
				for(int k=0;k<qtdDeAlunos;k++) {
					int AlunoRA = scan.nextInt();
					float notaAluno = scan.nextFloat();
					for(int l=0;l<d.getAlunos().size();l++) {  //busca do aluno
						
						if(d.getAlunos().get(l).getRA() == AlunoRA) {
							d.getAlunos().get(l).adicionarMateria(d.getMaterias().get(i)); //recriando o relacionamento AlunoMateria
							d.getAlunos().get(l).getMaterias().get(d.getAlunos().get(l).getMaterias().size() - 1).setNota(notaAluno); // recoloca a nota dessa materia
						}
					}
				}
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EscolaException e) {
			System.err.println(e);
		}
		
	}

	
	public Aluno matricularAluno(String nome, int idade, char sexo, String dataNascimento, String senha, int serie){
		Aluno novo_aluno = new Aluno (nome, idade, sexo, dataNascimento, senha, serie);
		alunos.add(novo_aluno);
		return novo_aluno;		
	}
	
	public boolean expulsarAluno(Aluno aluno) throws EscolaException{
		
		if (alunos.contains(aluno)){
			for (AlunoMateria ma: aluno.getMaterias()) {
				aluno.removerMateria(ma.getMateria());
			}
			
			alunos.remove(aluno);
			Aluno.setNumAlunos(Aluno.getNumAlunos()-1);
			
			return true;
			
		}
		else throw new EscolaException("Aluno nao encontrado\n");
		
	}
	
	public Professor contratarProfessor(String nome, int idade, char sexo, String dataNascimento, String senha, String sala, int salario){
		Professor novo_professor = new Professor(nome, idade, sexo, dataNascimento, senha, sala, salario);
		professores.add(novo_professor);
		return novo_professor;
	}
	
	public boolean demitirProfessor(Professor prof) throws EscolaException{
		
		if (professores.contains(prof)) {
		
			for (Materia ma: prof.getMaterias()) {
				//prof.removerMateria(ma);						<< Opcao 1
				try {
					desatribuirMateriaAUmProfessor(prof, ma);	//	<< Opcao 2 (ver funcao abaixo)
				}catch(EscolaException e) {
					System.err.print(e);
				}
			}
			
			professores.remove(prof);
			
			return true;
			
		}else{
			throw new EscolaException("Professor nao encontrado\n");		
			}
	}	
	
	// praticamente todo o trabalho de se atribuir uma materia a um professor está
	// na funcao adicionarMateria() que está na classe professor!
	public boolean atribuirMateriaAUmProfessor(Professor prof, Materia materia)throws EscolaException {
		if( prof.adicionarMateria(materia))
			return true;
		else
			throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() + " (cod. " + materia.getCodigo() + "): ja existe um professor responsavel pela materia");			
	}
	
	public boolean desatribuirMateriaAUmProfessor(Professor prof, Materia materia) throws EscolaException{
		
		if(prof.removerMateria(materia) == true)
			return true;
		else
			throw new EscolaException("Nao foi possivel remover a materia " + materia.getNome() + " (cod. " + materia.getCodigo() + "): o professor nao tem a materia.");			

	}
	
	public Materia abrirMateria(String nome, String codigo, int creditos, String sala, String horario, Dia dia, int capacidade, String ementa){
		Materia nova_materia = new Materia(nome, codigo, creditos, sala, horario, dia, capacidade, ementa);
		materias.add(nova_materia);
		return nova_materia;
	}
	
	public void fecharMateria(Materia materia){
		
		materia.getAlunosCadastrados().removeAll(materia.getAlunosCadastrados());
		materia.setProfessor(null);
		materias.remove(materia);
	}
	
	public boolean enviarMensagem(String mensagem,Pessoa p) throws EscolaException {
		if(p instanceof Professor) {
			System.out.println(mensagem);
			return true;
		}
		else if(p instanceof Aluno) {
			System.out.println(mensagem); //escreva no arquivo
			return true;
		}
		
		throw new EscolaException("O diretor e voce!\n");		
	}

	public void pagarProfessor(Professor prof) {
		if (prof.isPago() == false) {
			this.caixa -= prof.getSalario();
			prof.setPago(true);
		}
	}
	
	public void receberMensalidade(Aluno aluno, int valor_recebido) {
		aluno.setBalanco(aluno.getBalanco() + valor_recebido);
		this.caixa += valor_recebido;
	}
	
	// da um input ou um output do caixa. In: valor positivo; Out: valor negativo.
	public void inoutCaixa(int valor) {
		this.caixa += valor;
	}
	
	public void virarMes() {
		for (Aluno aluno:this.alunos) {
			aluno.setBalanco(aluno.getBalanco()-aluno.getMensalidade());
		}
		
		for (Professor prof:this.professores) {
			prof.setPago(false);
		}
		
		System.out.println("Balanco do mes: " + this.caixa);
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
	
	public int getCaixa() {
		return caixa;
	}

	public void setCaixa(int caixa) {
		this.caixa = caixa;
	}
	
}
