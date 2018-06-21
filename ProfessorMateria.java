public class ProfessorMateria {

	private Professor professor;
	private Materia   materia;
	
	public ProfessorMateria(Professor professor, Materia materia) {
		
		this.materia   = materia;
		this.professor = professor;
	}
	
	@Override
	public String toString() {
		
		String out = "O Professor " + professor.getNome() + " de RA " + 
				professor.getRA() + " eh responsavel pela materia " 
				+ materia.getNome() + "\n";
		return out;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}