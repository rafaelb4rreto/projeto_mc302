import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;


public class MyFrame3 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame3(Diretor d) {
		super("Cadastro");
		JTextField Id = new JTextField(10);
		JLabel nome = new JLabel("Nome: ");
		nome.setLabelFor(Id);
		nome.setDisplayedMnemonic('n');
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int flag = 0;
				if(d.getNome().equals(Id.getText())) {
					if(d.getSenha().equals(aut.getText())) {
						JOptionPane.showMessageDialog(null, "Entrada realizada com sucesso!");
						flag = 1;
					}
					if(flag == 0) {
						aut.setText("");
						Id.setText("");
					}
				}
				
				for(int i = 0;i < d.getProfessores().size();i++) {
					if(d.getProfessores().get(i).getNome().equals(Id.getText())) {
						if(d.getProfessores().get(i).getSenha().equals(aut.getText())) {
							JOptionPane.showMessageDialog(null, "Entrada realizada com sucesso!");
							flag = 1;
						}	
					}
				}
				
				if(flag == 0) {
					aut.setText("");
					Id.setText("");
				}
				
			}
		});
	}
}