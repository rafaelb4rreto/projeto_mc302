import java.awt.GridLayout;

import javax.swing.*;


public class AulaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	AulaFrame(Materia ma, Professor p){
		super(ma.getNome());
		
		JLabel nome_codigo_materia, creditos, sala, dia_horario, professor, capacidadeMax_Atual, ementa, lista_alunos;
		String lista_alunos_s;
		
		nome_codigo_materia = new JLabel(ma.getNome() + " / Cod.: " + ma.getCodigo() + "\n");
		creditos = new JLabel("Creditos: " + ma.getCreditos()+ "\n");
		sala = new JLabel("Sala: " + ma.getSala()+ "\n");
		dia_horario = new JLabel("Dia e horario: " + ma.getDia().nome_string + " - " + ma.getHorario());
		professor = new JLabel("Professor: " + ma.getProfessor().getNome() + "          ");
		capacidadeMax_Atual = new JLabel("N. Alunos/Capacidade: " + ma.getCapacidadeAtual() + "/" + ma.getCapacidadeMax());
		ementa = new JLabel("Ementa: " + ma.getEmenta()+ "         \n");
		
		lista_alunos_s = "Lista de alunos na materia:\n";
		for (AlunoMateria al : ma.getAlunosCadastrados()) {
			lista_alunos_s += al.getAluno().getNome() + "    RA: " + al.getAluno().getRA() + "\n";
		}
		
		lista_alunos = new JLabel(lista_alunos_s);
		
		this.getContentPane().setLayout(new GridLayout(0, 1));
		this.getContentPane().add(nome_codigo_materia);
		this.getContentPane().add(creditos);
		this.getContentPane().add(sala);
		this.getContentPane().add(dia_horario);
		this.getContentPane().add(professor);
		this.getContentPane().add(capacidadeMax_Atual);
		this.getContentPane().add(ementa);
		this.getContentPane().add(lista_alunos);
		this.getContentPane().setVisible(true);
		
		
	}
	
	AulaFrame(Materia ma, Aluno a){
		super(ma.getNome());
		
		JLabel nome_codigo_materia, creditos, sala, dia_horario, professor, nota, ementa;
		AlunoMateria alunoMateria = null;
		
		nome_codigo_materia = new JLabel(ma.getNome() + " / Cod.: " + ma.getCodigo() + "\n");
		creditos = new JLabel("Creditos: " + ma.getCreditos()+ "\n");
		sala = new JLabel("Sala: " + ma.getSala()+ "\n");
		dia_horario = new JLabel("Dia e horario: " + ma.getDia().nome_string + " - " + ma.getHorario());
		professor = new JLabel("Professor: " + ma.getProfessor().getNome());
		ementa = new JLabel("Ementa: " + ma.getEmenta()+ "      \n");
		
		for (AlunoMateria am : a.getMaterias()) {
			if (am.getMateria() == ma)
				alunoMateria = am;
		}
		
		nota = new JLabel("NOTA: " + alunoMateria.getNota());
		
		
		this.getContentPane().setLayout(new GridLayout(0, 1));
		this.getContentPane().add(nome_codigo_materia);
		this.getContentPane().add(creditos);
		this.getContentPane().add(sala);
		this.getContentPane().add(dia_horario);
		this.getContentPane().add(professor);
		this.getContentPane().add(nota);
		this.getContentPane().add(ementa);
		this.getContentPane().setVisible(true);
	}
	
}