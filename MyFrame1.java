import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame1 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame1(Diretor d) {
		
	super("Login");
	JTextField Id = new JTextField(10);
	JLabel nome = new JLabel("Nome: ");
	nome.setLabelFor(Id);
	nome.setDisplayedMnemonic('n');
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.getContentPane().setLayout(new FlowLayout());
	this.getContentPane().add(nome);
	this.getContentPane().add(Id);
	
	JTextField aut = new JPasswordField(10);
	JLabel senha = new JLabel("Senha: ");
	senha.setLabelFor(aut);
	senha.setDisplayedMnemonic('d');
	this.getContentPane().add(senha);
	this.getContentPane().add(aut);

	JButton botao = new JButton("Entrar");
	this.getContentPane().add(botao);
	
	JButton botao2 = new JButton("Voltar");
	this.getContentPane().add(botao2);

	this.getRootPane().setDefaultButton(botao);
	
	botao.addActionListener(new Listeners.LoginAlunoListener(Id,aut,d));
	botao2.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				Object[] option = {"Aluno","Professor","Diretor"};
				Login inicio = new Login(option,d);
				int p = inicio.classSelection(d);
				if(p == 0) {
					JFrame f = new MyFrame1(d);
					f.setSize(200,300);
					f.setLocationRelativeTo(null);
					f.show();
					
				}
				if(p == 1) {
					
				}
				if(p == 2) {
					JFrame fr = new MyFrame3(d);
					fr.setSize(200,300);
					fr.setLocationRelativeTo(null);
					fr.show();
				}

				
			}
			
		});

	}
	
}
