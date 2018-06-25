import java.util.ArrayList;
import java.util.Formatter;

public class Aluno extends Pessoa implements Salvar{
	
	private static int 	numAlunos = 0;
	private ArrayList<AlunoMateria> materias;
	private int 		balanco;
	private int			mensalidade;
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
		this.balanco		 = 0;
		this.mensalidade	 = 500;
		this.serie 	  		 = serie;
		this.advertencias 	 = 0;
		this.maxAdvertencias = 3;
		this.suspensoes 	 = 0;
		this.maxCreditos 	 = 20;
		this.numCreditos 	 = 0;
		this.regular  		 = true;
		
	}
	
	public void salvarDados(Formatter output) {
		
		output.format("%s %d %c %s %s %d", getNome(), getIdade(), getSexo(), getDataNascimento(), getSenha(), serie);
		output.format(" %d %d %d %d %b %d %d\n", getRA(), advertencias, suspensoes, maxCreditos, regular, balanco, mensalidade);
		
	}
	
	public boolean adicionarMateria(Materia materia) throws EscolaException{
		
		// caso os creditos adicionais fizerem o aluno extrapolar sua cota, nega a adicao
		if(numCreditos + materia.getCreditos() > this.getMaxCreditos()) {
			
			throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() +
					" (cod. " + materia.getCodigo() + "): creditos indisponiveis para a materia.");
		}
		
		// caso a materia ja esteja lotada de alunos nega a adicao
		else if(materia.getCapacidadeMax() == materia.getCapacidadeAtual()) {
			
			throw new EscolaException("Nao foi possivel adicionar a  materia " + materia.getNome() +
					" (cod. " + materia.getCodigo() + "): materia lotada.");
		}
	
		for(AlunoMateria alma: materias) {
			
			// caso ja tenha uma materia no mesmo dia...
			if(alma.getMateria().getDia() == materia.getDia()) {
				// ... e no mesmo horario, nega a adicao
				if(alma.getMateria().getHorario().equalsIgnoreCase(materia.getHorario())) {
					
					throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() +
							" (cod. " + materia.getCodigo() + "): conflito de horario com materias ja matriculadas.");
			
				}
			}
			
			// caso o aluno ja faca uma materia com o mesmo nome, nega a adicao
			else if(alma.getMateria().getNome().equalsIgnoreCase(materia.getNome())) {
				
				throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() + 
						" (cod. " + materia.getCodigo() + "): o aluno ja esta matriculado na materia.");
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
	public boolean removerMateria(Materia materia) throws EscolaException{
		
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				try {
					materia.removerAlunoCadastrado(alma);
					materias.remove(alma);
					this.setNumCreditos(this.numCreditos - materia.getCreditos());
				} catch(EscolaException e) {
					System.err.println(e);
				}
				
				System.out.println("Materia " + materia.getNome() +
						" (cod. " + materia.getCodigo() + ") removida do aluno " + this.getNome() + ".");
				
				return true;
			}
		}
		throw new EscolaException("o aluno nao esta cadastrado na materia");
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

	public int getBalanco() {
		return balanco;
	}

	public void setBalanco(int balanco) {
		this.balanco = balanco;
	}

	public int getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(int mensalidade) {
		this.mensalidade = mensalidade;
	}

}