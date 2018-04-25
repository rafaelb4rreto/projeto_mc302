import java.util.ArrayList;

public class Professor extends Pessoa{

	private ArrayList<ProfessorMateria> materias;
	private ArrayList<Aluno> tutorados;
	private String sala;
	private int salario;
	private static int numMaxTutorados;
	

	public Professor(String nome,int idade,char sexo,String dataNascimento,String senha,String sala,int salario) {
		
		super(nome,idade,sexo,dataNascimento,senha);
		materias = new ArrayList<ProfessorMateria>();
		tutorados = new ArrayList<Aluno>();
		this.sala = sala;
		this.salario = salario;
	}
	
	public static int getNumMaxTutorados() {
		return numMaxTutorados;
	}

	public void setNumMaxTutorados(int numMaxTutorados) {
		Professor.numMaxTutorados = numMaxTutorados;
	}

	public ArrayList<ProfessorMateria> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<ProfessorMateria> materias) {
		this.materias = materias;
	}

	public ArrayList<Aluno> getTutorados() {
		return tutorados;
	}

	public void setTutorados(ArrayList<Aluno> tutorados) {
		this.tutorados = tutorados;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public boolean adicionarMateria(Materia materia) {
		
		for(ProfessorMateria prma: materias) {
			
			if(prma.getMateria() == materia) {
				return false;
			}
		}
		
		if(materia.getProfessor() != null) {
			return false;
		}
		
		ProfessorMateria pm = new ProfessorMateria(this, materia);
		materias.add(pm);
		materia.setProfessor(this);
		return true;		
	}
	
	public boolean removerMateria(Materia materia) {
		
		for(ProfessorMateria profma: materias) {
			
			if(profma.getMateria() == materia) {
				
				materia.setProfessor(null);
				materias.remove(profma);
				return true;
			}
		}
		return false;	
	}
	
	
	public boolean adicionarTutorado(Aluno aluno) {
		if(tutorados.size() < numMaxTutorados) {
			return tutorados.add(aluno);
		}
		
		return false;
	}
	
	public boolean removerTutorado(Aluno aluno) {
		if(tutorados.contains(aluno)) {
			return tutorados.remove(aluno);
		}
		
		return false;
	}
	
	

	@Override
	public String toString() {
		String out = super.toString();
		out = out +  "\nProfessor [tutorados=" + tutorados + ", sala=" + sala + ", salario=" + salario +", materias="+ materias + "]";
		return out;
	}
	
	
	
}