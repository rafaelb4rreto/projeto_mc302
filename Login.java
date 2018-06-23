import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Login() {
		
		Object[] classes = {"Aluno","Professor","Diretor"};
		int answer = JOptionPane.showOptionDialog(null,"Que área gostaria de fazer login?","Tela de inicio", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,null, classes, classes[2]);
		
		
		if(answer == 0) { //Aluno esta tentando logar no sistema
			//String ra = JOptionPane.showInputDialog(null, "RA : ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
			
			JFrame f = new MyFrame1();
			f.pack();
			f.show();

			
		}
		else {
			JOptionPane.showMessageDialog(null, answer);
		}
		
		/*JTextField Id = new JTextField(10);
		JLabel nome = new JLabel("Nome: ");
		nome.setLabelFor(Id);
		nome.setDisplayedMnemonic('n');
		
		JTextField aut = new JTextField(10);
		JLabel senha = new JLabel("Senha: ");
		senha.setLabelFor(aut);
		senha.setDisplayedMnemonic('d');
		
		
		JButton botao = new JButton("Entrar");
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		}
		
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(operation);
		this.getContentPane().setLayout(new FlowLayout());
		this.getContentPane().add(nome);
		this.getContentPane().add(Id);
		this.getContentPane().add(senha);
		this.getContentPane().add(aut);
		
		
		this.getContentPane().add(botao);
		
		
		public boolean checaNome(String nome) {
			if(d.getAlunos())
		}*/
		
		
		
	}
	
	
	
	
	
}
