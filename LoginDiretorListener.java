import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class LoginDiretorListener implements ActionListener {

	private JTextField campo1,campo2;
	private Diretor d;
	
	public LoginDiretorListener(JTextField Id,JTextField aut,Diretor d) {
		this.campo1 = Id;
		this.campo2 = aut;
		this.d = d;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int flag = 0;
		
			if(d.getNome().equals(campo1.getText())) {
				if(d.getSenha().equals(campo2.getText())) {
					new Menu(d);
					flag = 1;
				}	
			}
		
		if(flag == 0) {
			campo2.setText("");
			campo1.setText("");
		}
		
	}
		
}


