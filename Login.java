import javax.swing.*;
import java.awt.FlowLayout;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("deprecation")
	public Login(Diretor d) {
		
		Object[] classes = {"Aluno","Professor","Diretor"};
		int answer = JOptionPane.showOptionDialog(null,"Que área gostaria de fazer login?","Tela de inicio", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,null, classes, classes[2]);
		
		
		if(answer == 0) { //Aluno esta tentando logar no sistema
			//String ra = JOptionPane.showInputDialog(null, "RA : ", "Cadastro", JOptionPane.PLAIN_MESSAGE);
			
			JFrame f = new MyFrame1(d);
			f.pack();
			f.show();

			
		}
		else if(answer == 1){
			JFrame p = new MyFrame2(d);
			p.pack();
			p.show();
			//JOptionPane.showMessageDialog(null, answer);
		}
		
		else {
			JFrame q = new MyFrame3(d);
			q.pack();
			q.show();
		}
		
	}
	
	
	
	
	
}
