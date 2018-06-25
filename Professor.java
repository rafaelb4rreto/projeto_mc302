import java.util.ArrayList;
import java.util.Formatter;

// professor eh uma subclasse de Pessoa
public class Professor extends Pessoa implements Salvar{

	private ArrayList<Materia> materias; // array list de materias que ele leciona
	private String  sala;				 // numero/nome/codigo da sala do professor
	private int     salario;				 // salario mensal do professor	
	private boolean pago;

	public Professor
	(String nome, int idade, char sexo, String dataNascimento, String senha, String sala, int salario) {
		
		super(nome, idade, sexo, dataNascimento, senha); // Atribui caracteristicas basicas de uma pessoa ao
														// professor ao construir um novo professor no sistema
		
		// aloca as array lists e inicializa a sala e o salario do professor
		materias     = new ArrayList<Materia>();
		this.sala    = sala;
		this.salario = salario;
		this.pago	 = false;
	}
	
	public void salvarDados(Formatter output) {
		
		output.format("%s %d %c %s %s %s %d", getNome(), getIdade(), getSexo(), getDataNascimento(), getSenha(), getSala(), getSalario());
		output.format(" %d %b\n", getRA(), pago);
		
	}	
	
	// Associa a materia ao professor
	public boolean adicionarMateria(Materia materia) throws EscolaException{
		
		if (materias.contains(materia)){
			throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() + " (cod. " + materia.getCodigo() + "): materia ja lecionada pelo professor");			
		}
		
		// se a materia ja estiver com um professor associado, nega o pedido
		if(materia.getProfessor() != null) {
			throw new EscolaException("Nao foi possivel adicionar a materia " + materia.getNome() + " (cod. " + materia.getCodigo() + "): ja existe um professor responsavel pela materia");			
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
	public boolean removerMateria(Materia materia) throws EscolaException {
		
		int materia_index = materias.indexOf(materia);
		
		if (materias.contains(materia) == false) {
			// neste ponto a materia nao foi encontrada em materias, entao nega o pedido de remocao
			throw new EscolaException("Nao foi possivel remover a materia " + materia.getNome() + " (cod. " + materia.getCodigo() + "): o professor nao leciona a materia.");			
		}else {
			materias.remove(materia_index);
			materia.setProfessor(null);
			
			System.out.println("Materia " + materia.getNome() + " (cod. " + materia.getCodigo() + ") removida do professor " + this.getNome() + ".");
			
			return true;
		}
	}
	
	
	public boolean editarEmenta(String ementa,Materia materia) throws EscolaException{
			
			if(this.getMaterias().contains(materia)) {
				
				materia.setEmenta(ementa);
				return true;
			}
			else {
				throw new EscolaException("Professor nao responsavel por esta materia\n");
			}
	
		}
	
	public boolean adicionarNotas(Aluno a,Materia materia, float nota) throws EscolaException{
		if(materias.contains(materia)) {
			for(int j = 0;j < materia.getAlunosCadastrados().size();j++) {
				//System.out.println("caiu "+a.getNome());
				if(materia.getAlunosCadastrados().get(j).getAluno().getRA() == a.getRA()) {
					materia.getAlunosCadastrados().get(j).setNota(nota);
					return true;
				}
			}
			throw new EscolaException("Aluno de RA "+a.getRA()+" nao esta cadastrado na materia "+materia.getNome()+"\n");		
		}
			throw new EscolaException("Professor tal nao responsavel por esta materia\n");		
	}
	
	public float mediaMateria(Materia m) throws EscolaException{
		float media = 0;
		if(materias.contains(m)) {
			for(int i = 0;i < m.getAlunosCadastrados().size();i++) {
				media += m.getAlunosCadastrados().get(i).getNota();
			}
			media = media/m.getAlunosCadastrados().size();
			return media;
		}
		else
			throw new EscolaException("Professor nao responsavel por esta materia\n");		
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
	public boolean isPago() {
		return pago;
	}
	public void setPago(boolean pago) {
		this.pago = pago;
	}
}