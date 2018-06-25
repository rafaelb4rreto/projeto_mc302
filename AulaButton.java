import javax.swing.*;

public class AulaButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	Materia materia;
	
	AulaButton(String text, Materia materia){
		super(text);
		this.materia = materia;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
}