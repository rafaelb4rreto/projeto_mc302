import java.util.ArrayList;

// professor eh uma subclasse de Pessoa
public class Professor extends Pessoa{

	private ArrayList<ProfessorMateria> materias; // array list de materias que ele leciona
	private ArrayList<Aluno> tutorados;			  // array list de tutorados que ele tutoria
	private String sala;						  // numero/nome/codigo da sala do professor
	private int salario;						  // salario mensal do professor
	private static int numMaxTutorados;			  // quantidade maxima de tutorados permitida ao professor
	

	public Professor
	(String nome, int idade, char sexo, String dataNascimento, String senha, String sala, int salario) {
		
		super(nome, idade, sexo, dataNascimento, senha); // Atribui caracteristicas basicas de uma pessoa ao
														// professor ao construir um novo professor no sistema
		
		// aloca as array lists e inicializa a sala e o salario do professor
		materias = new ArrayList<ProfessorMateria>();
		tutorados = new ArrayList<Aluno>();
		this.sala = sala;
		this.salario = salario;
	}
	
	public boolean adicionarMateria(Materia materia) {
		
		// percorre todo o array list materias
		for(ProfessorMateria prma: materias) {
			
			// se a materia ja estiver em materias nega o pedido de adicao de materia
			if(prma.getMateria() == materia) {
				return false;
			}
		}
		
		// se a materia ja estiver com um professor associado, nega o pedido
		if(materia.getProfessor() != null) {
			return false;
		}
		
		/* neste ponto o pedido eh valido.
		 * Aloca um objeto de associacao ProfessorMateria e atribuia materia a ser adicionada a ele.
		 * Depois adiciona esse objeto a array list de materias do professor
		 * e por fim seta o objeto atual (this) do professor  como sendo o professor da materia.
		 */
		ProfessorMateria pm = new ProfessorMateria(this, materia);
		materias.add(pm);
		materia.setProfessor(this);
		return true;		
	}
	
	public boolean removerMateria(Materia materia) {
		
		// percorre materias
		for(ProfessorMateria profma: materias) {
			
			// compara ate achar a materia a ser removida
			if(profma.getMateria() == materia) {
				
				materia.setProfessor(null);
				materias.remove(profma);
				return true;
			}
		}
		
		// neste ponto a materia nao foi encontrada em materias, entao nega o pedido de remocao
		return false;	
	}
	
	public boolean adicionarTutorado(Aluno aluno) {
		
		// antes de adicionar verifica se a quantidade de tutorados ja nao esta no maximo
		if(tutorados.size() < numMaxTutorados) {
			return tutorados.add(aluno);
		}
		
		return false;
	}
	
	public boolean removerTutorado(Aluno aluno) {
		
		// antes de remover verifica se o aluno eh um dos tutorados do professor
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
	
}