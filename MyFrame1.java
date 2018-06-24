import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.*;

public class MyFrame1 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame1(Diretor d) {
		
	super("Cadastro");
	JTextField Id = new JTextField(10);
	JLabel nome = new JLabel("Nome: ");
	nome.setLabelFor(Id);
	nome.setDisplayedMnemonic('n');
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.getContentPane().setLayout(new FlowLayout());
	this.getContentPane().add(nome);
	this.getContentPane().add(Id);
	
	JTextField aut = new JTextField(10);
	JLabel senha = new JLabel("Senha: ");
	senha.setLabelFor(aut);
	senha.setDisplayedMnemonic('d');
	this.getContentPane().add(senha);
	this.getContentPane().add(aut);

	JButton botao = new JButton("Entrar");
	this.getContentPane().add(botao);

	
	botao.addActionListener(new LoginAlunoListener(Id,aut,d));
	}

}
