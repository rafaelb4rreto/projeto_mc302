import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private ArrayList<AlunoMateria> materias;
	private int serie;
	private boolean tutoria;
	private int advertencias;
	private String periodo;
	private static int numAlunos = 0;
	private int suspensoes;
	private boolean regular;
	private static int maxAdv = 3;
	private static int maxSusp = 3;
	private  int maxCred;
	private int credAtual;
	

	public Aluno
	(String nome, int idade, char sexo, String dataNascimento, String senha, int serie,
	 boolean tutoria, int advertencias, int suspensoes, String periodo) {
		
		super(nome, idade, sexo, dataNascimento, senha);
		
		this.serie = serie;
		this.tutoria = tutoria;
		this.advertencias = advertencias;
		this.periodo = periodo;
		materias = new ArrayList<AlunoMateria>();
		this.regular = true;
		this.suspensoes = suspensoes;
		numAlunos++;
		maxCred = 20;
		credAtual = 0;
	}
	
	public boolean adicionarMateria(Materia materia) {
		
		// caso os creditos adicionais fizerem o aluno extrapolar sua cota, nega a adicao
		if(credAtual + materia.getCreditos() > this.getMaxCred()) {
			
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
		materia.adicionarAlunosCadastrados(am);
		this.setCredAtual(credAtual + materia.getCreditos());
		
		System.out.println("Materia " + materia.getNome() +
				" (cod. " + materia.getCodigo() + "): adicionada.");
		
		return true;
	
	}

	public boolean adicionarNotas(Materia materia,float nota) {
		
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
				
				materia.removerAlunosCadastrados(alma);
				materias.remove(alma);
				this.setCredAtual(this.credAtual - materia.getCreditos());
				
				System.out.println("Materia " + materia.getNome() +
						" (cod. " + materia.getCodigo() + ") removida do aluno " + this.getNome() + ".");
				
				return true;
			}
		}
				
		System.out.println("Nao foi possivel remover materia: o aluno nao esta matriculado na materia");
		return false;	
	}
	
	@Override
	public String toString() {
		String out = "==> Aluno(a) " + super.getNome() + " (RA: " + super.getRA() + ") | ";
		out += "Aluno(a) regular? " + this.isRegular() + " | ";
		out += "Creditos: " + credAtual + " (max: " + maxCred + ")\n";
		out += "    Serie: " + serie + " | Periodo: " + periodo + " | Esta em tutoria? " + tutoria + "\n";
		out += "    Matriculas: ";
		for(AlunoMateria am: materias) {
			out += "* " + am.getMateria().getNome();
			out += " (nota " + am.getNota() + ")  ";
		}
		return out;
	}
	
	public int getCredAtual() {
		return credAtual;
	}

	public void setCredAtual(int credAtual) {
		this.credAtual = credAtual;
	}
	
	public int getMaxCred() {
		return maxCred;
	}

	public void setMaxCred(int maxCred) {
		this.maxCred = maxCred;
	}
	
	public int getMaxAdvertencias() {
		return maxAdv;
	}
	
	public int getMaxSuspensoes() {
		return maxSusp;
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
	
	public static int getNumAlunos() {
		return numAlunos;
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
	
	public boolean isTutoria() {
		return tutoria;
	}
	
	public void setTutoria(boolean tutoria) {
		this.tutoria = tutoria;
	}
	
	public int getAdvertencias() {
		return advertencias;
	}
	
	public void setAdvertencias(int advertencias) {
		this.advertencias = advertencias;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}	

}