import java.util.ArrayList;

// professor eh uma subclasse de Pessoa
public class Professor extends Pessoa{

	private ArrayList<Materia> materias; // array list de materias que ele leciona
	private String sala;				 // numero/nome/codigo da sala do professor
	private int    salario;				 // salario mensal do professor	

	public Professor
	(String nome, int idade, char sexo, String dataNascimento, String senha, String sala, int salario) {
		
		super(nome, idade, sexo, dataNascimento, senha); // Atribui caracteristicas basicas de uma pessoa ao
														// professor ao construir um novo professor no sistema
		
		// aloca as array lists e inicializa a sala e o salario do professor
		materias     = new ArrayList<Materia>();
		this.sala    = sala;
		this.salario = salario;
	}
	
	// Associa a materia ao professor
	public boolean adicionarMateria(Materia materia) {
		
		if (materias.contains(materia)){
			System.out.println("Nao foi possivel add a materia " + materia.getNome() + 
					" (cod. " + materia.getCodigo() + "): materia ja existente.");
			
			return false;
		}
		
		// se a materia ja estiver com um professor associado, nega o pedido
		if(materia.getProfessor() != null) {
			
			System.out.println("Nao foi possivel add a materia " + materia.getNome() + 
					" (cod. " + materia.getCodigo() + "): a materia ja tem um professor.");
			
			return false;
		}
		
		/* neste ponto o pedido eh valido.
		 * Aloca um objeto de associacao ProfessorMateria e atribuia materia a ser adicionada a ele.
		 * Depois adiciona esse objeto a array list de materias do professor
		 * e por fim seta o objeto atual (this) do professor  como sendo o professor da materia.
		 */
		materias.add(materia);
		materia.setProfessor(this);		
		
		System.out.println("Materia " + materia.getNome() + 
				" (cod. " + materia.getCodigo() + ") adicionada ao professor " + this.getNome() + ".");
		
		return true;		
	}
	
	// Desassocia a materia ao professor
	public boolean removerMateria(Materia materia) {
		
		int materia_index = materias.indexOf(materia);
		
		if (materia_index == -1) {
			// neste ponto a materia nao foi encontrada em materias, entao nega o pedido de remocao
			System.out.println("Nao foi possivel remover a materia " + materia.getNome() + 
					" (cod. " + materia.getCodigo() + "): o professor nao tem a materia.");
			
			return false;
		}else {
			materias.remove(materia_index);
			materia.setProfessor(null);
			
			System.out.println("Materia " + materia.getNome() + 
					" (cod. " + materia.getCodigo() + ") removida do professor " + this.getNome() + ".");
			
			return true;
		}
	}
	
	
	@Override
	public String toString() {
		String out = "Professor: " + super.getNome() + ", n. materias: " + getMaterias().size() + "\n";
		
		return out;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(ArrayList<Materia> materias) {
		this.materias = materias;
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