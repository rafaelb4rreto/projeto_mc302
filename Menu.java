import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Menu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel materias = new JLabel("Que materias você deseja cursar: ");
	private Aluno a;
	private Diretor d;
	
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor) {
		super("Menu");
		
		Object[] options = {"Matricular aluno","Advertir aluno","Suspender aluno","Expulsar aluno","Contratar professor","Demitir Professor","Atribuir materias","Desatribuir materias","Abrir materia","Fechar materia","Pagar professor","Receber Mensalidade","Virar mes"};
	
		int r = JOptionPane.showOptionDialog(null, "O que deseja fazer?","Menu",JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,null, options, options[12]);
		
		if(r == 0) {
			JFrame dados = new JFrame();
			Container c = dados.getContentPane();
			c.setLayout(new FlowLayout());
			JTextField campoNome,campoIdade,campoSexo,campoDataNascimento,campoSenha,campoSerie;
			JLabel nome,idade,sexo,data,senha,serie;
			
			campoNome = new JTextField(20);
			campoIdade = new JTextField(2);
			campoSexo = new JTextField(1);
			campoDataNascimento = new JTextField(10);
			campoSenha = new JTextField(10);
			campoSerie = new JTextField(1);
			
			nome = new JLabel("Nome: ");
			idade = new JLabel("Idade: ");
			sexo = new JLabel("Sexo: ");
			data = new JLabel("Data de nascimento: ");
			senha = new JLabel("Senha: ");
			serie = new JLabel("Serie: ");
			
			nome.setLabelFor(campoNome);
			idade.setLabelFor(campoIdade);
			sexo.setLabelFor(campoSexo);
			data.setLabelFor(campoDataNascimento);
			senha.setLabelFor(campoSenha);
			serie.setLabelFor(campoSerie);
			
			c.add(nome);
			c.add(campoNome);
			c.add(idade);
			c.add(campoIdade);
			c.add(sexo);
			c.add(campoSexo);
			c.add(data);
			c.add(campoDataNascimento);
			c.add(senha);
			c.add(campoSenha);
			c.add(serie);
			c.add(campoSerie);
			
			
			JButton b = new JButton("Matricular");
			
			b.addActionListener(new MatriculaListener(campoNome.getText(),campoIdade.getText(),campoSexo.getText(),campoDataNascimento.getText(),campoSenha.getText(),campoSerie.getText(),diretor));

			c.add(b);
			
			
			
			dados.pack();
			dados.show();
			
			
		}	
		
		else if(r == 1) {
					
				}	
		
		else if(r == 2) {
			
		}	
		
		else if(r == 3) {
			
		}	
		
		else if(r == 4) {
			
		}	
		
		else if(r == 5) {
			
		}	
		
		else if(r == 6) {
			
		}	
		
		else if(r == 7) {
			
		}	
		
		else if(r == 8) {
			
		}	
		
		else if(r == 9) {
			
		}	
		
		else if(r == 10) {
			
		}	
		
		else if(r == 11) {
			
		}	
		
		else if(r == 12) {
			
		}	
	}
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor,Aluno aluno) {
		super("Menu");
		
		a = aluno;
		d = diretor; 
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		JButton botao1 = new JButton("Adicionar Materia");
		JButton botao2 = new JButton("Remover Materia");
		JButton botao3 = new JButton("Mandar Mensagem");
		
		c.add(botao1);
		c.add(botao2);
		c.add(botao3);
		
		this.pack();
		this.show();
		
		//c.getComponent(0).setSize(100,100);
		//c.getComponent(1).setSize(100,100);
		//c.getComponent(2).setSize(100,100);
		
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame materia = new JFrame("Escolha de Materias");
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Adicionar");
				materia.getContentPane().setLayout(new FlowLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new AdicionaMateriaListener(materia,txt,diretor,aluno));

				
				materia.pack();
				materia.show();
 			}
		});

		botao2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame materia = new JFrame("Escolha de Materias");
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Remover");
				materia.getContentPane().setLayout(new FlowLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new RemoveMateriaListener(materia,txt,diretor,aluno));
				
				materia.pack();
				materia.show();
			}
			
		});

	}
	
}