import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private ArrayList<AlunoMateria> materias;
	private int serie;
	private boolean tutoria;
	private int advertencias;
	private String periodo;
	private static int numAlunos = 0;
	
	public Aluno(String nome,int idade,char sexo,String dataNascimento,String senha,int serie,boolean tutoria,int advertencias,String periodo) {
		
		super(nome,idade,sexo,dataNascimento,senha);
		this.serie = serie;
		this.tutoria = tutoria;
		this.advertencias = advertencias;
		this.periodo = periodo;
		materias = new ArrayList<AlunoMateria>();
		numAlunos++;
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
		
		for(AlunoMateria alma: materias) {
			
			if(alma.getMateria() == materia) {
				return false;
			}
		}
		
		AlunoMateria am = new AlunoMateria(this, materia);
		materias.add(am);
		materia.adcionarAlunosCadastrados(am);
		
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
				return true;
			}
		}
		return false;	
	}


	@Override
	public String toString() {
		String out = "Aluno " + super.getNome() + " (RA: " + super.getRA() + ")";
		out += " esta matriculado em:\n";
		for(AlunoMateria am: materias) {
			out += "* " + am.getMateria().getNome() + "\n";
		}
		return out;
	}

	

}
