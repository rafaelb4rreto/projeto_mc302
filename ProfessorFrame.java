import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;


public class ProfessorFrame extends JFrame{
	
	/**
	 * O que deve aparecer na tela do professor?
	 * - Nome e RA
	 * - Salario
	 * - Se ja foi pago
	 * - Mensagens (botão?)
	 * - Quadro com as materias que ele leciona (grade de horarios. Clicando
	 *   vai para uma página com detalhes da matéria e mudanças que o prof pode fazer)
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	GridLayout grid, infos;
	
	JLabel nome, ra, salario, pago;
	JButton mensagens;
	Component[][] aula_grid;
	
	String 	   horario_info;
	String	   materia_info;
	int 	   coluna_dia;
	int		   linha_horario;
	
	public ProfessorFrame(Professor p) {
		
		super("Professor " + p.getRA());
		
		Materia ma_buff = null;
		
		nome 	= new JLabel();		
		ra 		= new JLabel("RA: " + p.getRA());
		salario = new JLabel("Salario: " + p.getSalario());
		pago 	= new JLabel();
		
		grid 	  = new GridLayout(0, 6);
		
	//	infos	  = new GridLayout(1, 5);
		mensagens = new JButton("Mensagens");		
		aula_grid = new AulaButton[6][6];
		
		if (p.getSexo() == 'M')
			nome.setText("Professor " + p.getNome());
		else if (p.getSexo() == 'F')
			nome.setText("Professora " + p.getNome());
		else
			nome.setText("Professor(a) " + p.getNome());
		
		if (p.isPago() == true) {
			pago.setText(" Salário PAGO ");
			pago.setBorder(BorderFactory.createLineBorder(Color.green));
		}else {
			pago.setText(" Salário NÃO PAGO ");
			pago.setBorder(BorderFactory.createLineBorder(Color.red));
		}
	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.getContentPane().setLayout(infos);
		this.getContentPane().add(nome);
		this.getContentPane().add(ra);
		this.getContentPane().add(salario);
		this.getContentPane().add(pago);
		this.getContentPane().add(new JLabel(""));
		this.getContentPane().add(mensagens);
		
		
		// Painel de horarios
		this.getContentPane().setLayout(grid);
		
		this.getContentPane().add(new JLabel("---"));
		for (int i = Dia.SEGUNDA.valor; i <= Dia.SEXTA.valor; i++) {
			this.getContentPane().add(new JLabel(Dia.values()[i-1].nome_string));
		}
		
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				horario_info = "08h - 10h\n";
			}else if (i == 1) {
				horario_info = "10h - 12h\n";
			}else if (i == 2) {
				horario_info = "12h - 14h\n";
			}else if (i == 3) {
				horario_info = "14h - 16h\n";
			}else
				horario_info = "16h - 18h\n";
			
			this.getContentPane().add(new JLabel(horario_info));
			
			for (int j = Dia.SEGUNDA.valor; j <= Dia.SEXTA.valor; j++) {
				linha_horario = -1;
				for (Materia ma : p.getMaterias()) {
					
					if (ma.getDia().valor == j) {
						
						materia_info  = ma.getNome() + " / Cod.: " + ma.getCodigo();
						coluna_dia 	  = ma.getDia().valor;
						
						if (ma.getHorario() == "08h" && i == 0) {
							linha_horario = 1;
							ma_buff = ma;
						}else if (ma.getHorario() == "10h" && i == 1) {
							linha_horario = 2;
							ma_buff = ma;
						}else if (ma.getHorario() == "14h" && i == 3) {
							linha_horario = 4;
							ma_buff = ma;
						}else if (ma.getHorario() == "16h" && i == 4) {
							linha_horario = 5;
							ma_buff = ma;
						}
					}
				}
				if (linha_horario != -1) {
					aula_grid[i][j-1] = new AulaButton("", ma_buff);
					((AulaButton)aula_grid[i][j-1]).setLayout(new BorderLayout());
					((AulaButton) aula_grid[i][j-1]).add(BorderLayout.NORTH,  new JLabel(horario_info + " / " + "Sala: " + ma_buff.getSala()));
					((AulaButton) aula_grid[i][j-1]).add(BorderLayout.CENTER, new JLabel(materia_info));
					((AulaButton) aula_grid[i][j-1]).add(BorderLayout.SOUTH,  new JLabel("N. alunos: " + ma_buff.getCapacidadeAtual()));
					this.getContentPane().add(aula_grid[i][j-1]);
					
					((AulaButton) aula_grid[i][j-1]).addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
						// mostrar tela de detalhes da materia (aula_grid[linha_horario-1][coluna_dia-1].getMateria()
							
						}
					});
				}else {
					this.getContentPane().add(new JButton(""));
				}
			}		
		}
		
		
	}

}