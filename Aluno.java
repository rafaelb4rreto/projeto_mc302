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
	
	

	


	

	public Aluno(String nome,int idade,char sexo,String dataNascimento,String senha,int serie,boolean tutoria,int advertencias,int suspensoes,String periodo) {
		
		super(nome,idade,sexo,dataNascimento,senha);
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

	public boolean adicionarMateria(Materia materia) {
		
			
		
			if(credAtual + materia.getCreditos() > this.getMaxCred())
				return false;
			
			if(materia.getCapacidadeMax() == materia.getCapacidadeAtual())
				return false;
		
			for(AlunoMateria alma: materias) {
				
				if(alma.getMateria().getDia() == materia.getDia()) {
					if(alma.getMateria().getHorario().equalsIgnoreCase(materia.getHorario()))
						return false;
				}
				
				if(alma.getMateria().getNome().equalsIgnoreCase(materia.getNome())) {
					return false;
				}
			}
			
			
			AlunoMateria am = new AlunoMateria(this, materia);
			materias.add(am);
			materia.adicionarAlunosCadastrados(am);
			this.setCredAtual(credAtual + materia.getCreditos());
			
			return true;
		
	}
	
	public boolean adicionarNotas(Materia materia,float nota) {
		
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				
				alma.setNota(nota);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerMateria(Materia materia) {
		
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				
				materia.removerAlunosCadastrados(alma);
				materias.remove(alma);
				this.setCredAtual(this.credAtual - materia.getCreditos());
				return true;
			}
		}
		return false;	
	}


	@Override
	public String toString() {
		String out = "Aluno " + super.getNome() + " (RA: " + super.getRA() + ")";
		out += "\naluno regular: "+ this.isRegular();
		out += "\n esta matriculado em:\n";
		for(AlunoMateria am: materias) {
			out += "* " + am.getMateria().getNome();
			out += " (nota: "+am.getNota()+ ")\n";
		}
		out += "aluno esta cursando "+credAtual+" de um maximo de "+maxCred;
		return out;
	}

	

}
