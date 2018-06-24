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
	
	
	
	public Menu(Diretor diretor) {
		super("Menu");
		
		
		
			JFrame dados = new JFrame();
			Container c = dados.getContentPane();
			c.setLayout(new FlowLayout());
			JTextField campoNome,campoIdade,campoSexo,campoDataNascimento,campoSenha,campoSerie;
			JLabel nome,idade,sexo,data,senha,serie;
			
			JButton b1 = new JButton("Matricular Aluno");
			JButton b2 = new JButton("Advertir Aluno");
			JButton b3 = new JButton("Suspender Aluno");
			JButton b4 = new JButton("Expulsar Aluno");
			JButton b5 = new JButton("Contratar Professor");
			JButton b6 = new JButton("Demitir Professor");
			JButton b7 = new JButton("Atribuir Materia");
			JButton b8 = new JButton("Desatribuir Materia");
			JButton b9 = new JButton("Abrir Materia");
			JButton b10 = new JButton("Fechar Materia");
			JButton b11 = new JButton("Enviar Mensagem");
			JButton b12 = new JButton("Pagar Professor");
			JButton b13 = new JButton("Receber Mensalidade");
			
			c.add(b1);
			c.add(b2);
			c.add(b3);
			c.add(b4);
			c.add(b5);
			c.add(b6);
			c.add(b7);
			c.add(b8);
			c.add(b9);
			c.add(b10);
			c.add(b11);
			c.add(b12);
			c.add(b13);
			
			//b1.addActionListener(new MatriculaListener());
			
			
		/*	campoNome = new JTextField(20);
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
			
			dados.getContentPane().add(nome);
			dados.getContentPane().add(campoNome);
			dados.getContentPane().add(idade);
			dados.getContentPane().add(campoIdade);
			dados.getContentPane().add(sexo);
			dados.getContentPane().add(campoSexo);
			dados.getContentPane().add(data);
			dados.getContentPane().add(campoDataNascimento);
			dados.getContentPane().add(senha);
			dados.getContentPane().add(campoSenha);
			dados.getContentPane().add(serie);
			dados.getContentPane().add(campoSerie);*/
			
			dados.pack();
			dados.show();
	
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