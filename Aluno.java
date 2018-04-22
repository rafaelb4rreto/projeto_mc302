import java.util.ArrayList;

public class Aluno extends Pessoa {
	
	private ArrayList<Materia> materias;
	private int serie;
	private boolean tutoria;
	private int advertencias;
	private String periodo;
	private ArrayList<Integer> notas;
	private static int numAlunos = 0;
	
	public Aluno(String nome,int idade,char sexo,String dataNascimento,String RA,String senha,int serie,boolean tutoria,int advertencias,String periodo) {
		super(nome,idade,sexo,dataNascimento,RA,senha);
		this.serie = serie;
		this.tutoria = tutoria;
		this.advertencias = advertencias;
		this.periodo = periodo;
		materias = new ArrayList<Materia>();
		notas = new ArrayList<Integer>();
		numAlunos++;
	}
	
	
	
	public ArrayList<Integer> getNotas() {
		return notas;
	}



	public void setNotas(ArrayList<Integer> notas) {
		this.notas = notas;
	}



	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	public void setMaterias(ArrayList<Materia> materias) {
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
		if(materias.contains(materia))
			return false;
		materias.add(materia);
		notas.add(Integer.MAX_VALUE);
		//materia.adcionarAlunosCadastrados(this);
		return true;
	}
	
	public boolean adicionarNotas(Materia materia,int nota) {
		int a;
		a = materias.indexOf(materia);
		if(materias.get(a) != null) {
			notas.set(a,nota);
			
			return true;
		}
		
		return false;	
	}
	
	public boolean removerMateria(Materia materia) {
		if(!materias.contains(materia))
			return false;
		else {
			materia.removerAlunosCadastrados(this);
			notas.remove(materias.indexOf(materia));
			materias.remove(materia);
			
			return true;
		}
	}


	@Override
	public String toString() {
		String out = super.toString();
		out = out + "Aluno [materias=" + materias + ", serie=" + serie + ", tutoria=" + tutoria + ", advertencias="+ advertencias + ", periodo=" + periodo + ", notas= " + notas + " numAlunos = "+numAlunos+"]";
		return out;
	}

	

}
