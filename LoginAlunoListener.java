import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class LoginAlunoListener implements ActionListener{

	private JTextField campo1,campo2;
	private Diretor d;
	
	public LoginAlunoListener(JTextField Id,JTextField aut,Diretor d) {
		this.campo1 = Id;
		this.campo2 = aut;
		this.d = d;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int flag = 0;
		for(int i = 0;i < d.getAlunos().size();i++) {
			if(d.getAlunos().get(i).getNome().equals(campo1.getText())) {
				if(d.getAlunos().get(i).getSenha().equals(campo2.getText())) {
					Aluno aluno = d.getAlunos().get(i);
					new Menu(d,aluno);
					flag = 1;
				}	
			}
		}
		
		if(flag == 0) {
			campo2.setText("");
			campo1.setText("");
		}
		
	}
	

}
