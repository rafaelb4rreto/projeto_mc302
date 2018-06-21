import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private static int 	numAlunos = 0;
	private ArrayList<AlunoMateria> materias;
	private int 		balanco;
	private int 		serie;
	private int 		advertencias;
	private int 		maxAdvertencias;
	private int 		suspensoes;
	private boolean 	regular;	
	private int			maxCreditos;
	private int 		numCreditos;
	

	public Aluno
	(String nome, int idade, char sexo, String dataNascimento, String senha, int serie) {
		super(nome, idade, sexo, dataNascimento, senha);
		
		numAlunos++;
		this.materias = new ArrayList<AlunoMateria>();
		this.serie 	  		 = serie;
		this.advertencias 	 = 0;
		this.maxAdvertencias = 3;
		this.suspensoes 	 = 0;
		this.maxCreditos 	 = 5;
		this.numCreditos 	 = 0;
		this.regular  		 = true;
		
	}
	
	public boolean adicionarMateria(Materia materia) {
		
		// caso os creditos adicionais fizerem o aluno extrapolar sua cota, nega a adicao
		if(numCreditos + materia.getCreditos() > this.getMaxCreditos()) {
			
			System.out.println("Nao foi possivel adicionar a materia " + materia.getNome() +
					" (cod. " + materia.getCodigo() + "): creditos indisponiveis para a materia.");
			
			return false;
		}
		
		// caso a materia ja esteja lotada de alunos nega a adicao
		if(materia.getCapacidadeMax() == materia.getCapacidadeAtual()) {
			
			System.out.println("Nao foi possivel adicionar a  materia " + materia.getNome() +
					" (cod. " + materia.getCodigo() + "): materia lotada.");
			
			return false;
		}
	
		for(AlunoMateria alma: materias) {
			
			// caso ja tenha uma materia no mesmo dia...
			if(alma.getMateria().getDia() == materia.getDia()) {
				// ... e no mesmo horario, nega a adicao
				if(alma.getMateria().getHorario().equalsIgnoreCase(materia.getHorario())) {
					
					System.out.println("Nao foi possivel adicionar a materia " + materia.getNome() +
							" (cod. " + materia.getCodigo() + "): conflito de horario com materias ja matriculadas.");
					
					return false;
				}
			}
			
			// caso o aluno ja faca uma materia com o mesmo nome, nega a adicao
			if(alma.getMateria().getNome().equalsIgnoreCase(materia.getNome())) {
				
				System.out.println("Nao foi possivel adicionar a materia " + materia.getNome() + 
						" (cod. " + materia.getCodigo() + "): o aluno ja esta matriculado na materia.");
				
				return false;
			}
		}
		
		AlunoMateria am = new AlunoMateria(this, materia);
		materias.add(am);
		materia.adicionarAlunoCadastrado(am);
		this.setNumCreditos(numCreditos + materia.getCreditos());
		
		System.out.println("Materia " + materia.getNome() +
				" (cod. " + materia.getCodigo() + "): adicionada.");
		
		return true;
	
	}

	public boolean adicionarNotas(Materia materia, float nota) {
		
		// percorre materias para achar a materia para adicionar a nota
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				
				System.out.println("Nota " + nota + " adicionada a materia " + materia.getNome() +
				" (cod. " + materia.getCodigo() + ").");
				
				alma.setNota(nota);
				return true;
			}
		}
		
		// nega a adicao de nota caso o aluno nao faca a materia
		System.out.println("Nao foi possivel adicionar nota: o aluno nao esta matriculado na materia.");
		return false;
	}

	public boolean removerMateria(Materia materia) {
		
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				
				materia.removerAlunoCadastrado(alma);
				materias.remove(alma);
				this.setNumCreditos(this.numCreditos - materia.getCreditos());
				
				System.out.println("Materia " + materia.getNome() +
						" (cod. " + materia.getCodigo() + ") removida do aluno " + this.getNome() + ".");
				
				return true;
			}
		}
				
		System.out.println("Nao foi possivel remover materia: o aluno nao esta matriculado na materia");
		return false;	
	}
	
public boolean enviarMensagem(String mensagem,Pessoa p) {
		

		if(p instanceof Aluno) {
			//excecao
		}
		
		else if(p instanceof Professor) {
			
			for(int i = 0;i < this.materias.size();i++) {
				if(materias.get(i).getMateria().getProfessor() == (Professor)p) {
					System.out.println(mensagem);//escreva no arquivo
					return true;
				}				
			}		
		}
		
		System.out.println("Voce nao tem autorizacao para isso!"); //excecao!!!!
		return false;
	}
	
	@Override
	public String toString() {
		String out = "Aluno: " + super.getNome() + ", n. materias: " + getMaterias().size() + "\n";
		return out;
	}

	public static int getNumAlunos() {
		return numAlunos;
	}

	public static void setNumAlunos(int numAlunos) {
		Aluno.numAlunos = numAlunos;
	}

	public ArrayList<AlunoMateria> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<AlunoMateria> materias) {
		this.materias = materias;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getAdvertencias() {
		return advertencias;
	}

	public void setAdvertencias(int advertencias) {
		this.advertencias = advertencias;
	}

	public int getMaxAdvertencias() {
		return maxAdvertencias;
	}

	public void setMaxAdvertencias(int maxAdvertencias) {
		this.maxAdvertencias = maxAdvertencias;
	}

	public int getSuspensoes() {
		return suspensoes;
	}

	public void setSuspensoes(int suspensoes) {
		this.suspensoes = suspensoes;
	}

	public boolean isRegular() {
		return regular;
	}

	public void setRegular(boolean regular) {
		this.regular = regular;
	}

	public int getMaxCreditos() {
		return maxCreditos;
	}

	public void setMaxCreditos(int maxCreditos) {
		this.maxCreditos = maxCreditos;
	}

	public int getNumCreditos() {
		return numCreditos;
	}

	public void setNumCreditos(int numCreditos) {
		this.numCreditos = numCreditos;
	}

}