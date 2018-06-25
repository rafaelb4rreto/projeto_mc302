public class AlunoMateria {
	
	private Aluno 	aluno;
	private Materia materia;
	private float 	nota;
	
	public AlunoMateria(Aluno aluno, Materia materia) {
		
		this.aluno 	 = aluno;
		this.materia = materia;
	}
	
	@Override
	public String toString() {
		
		String out = "Aluno " + aluno.getNome() + " de RA " + aluno.getRA()
				+ " esta matriculado na materia " + materia.getNome() + ".\n";
		return out;
	}
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Materia getMateria() {
		return materia;
	}
	
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}	

}