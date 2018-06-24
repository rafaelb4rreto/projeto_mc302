import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RemoveMateriaListener implements ActionListener{
	private JTextField campo;
	private Diretor d;
	private Aluno aluno;
	private JFrame m;
	
	public RemoveMateriaListener(JFrame materia,JTextField campo,Diretor d,Aluno a){
		this.campo = campo;
		this.d = d;
		this.aluno = a;
		this.m = materia;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		int flag = 0;
		for(int i = 0;i < d.getMaterias().size();i++) {
			if(d.getMaterias().get(i).getCodigo().equals(campo.getText())) {
				try {
					flag = 1;
					aluno.removerMateria(d.getMaterias().get(i));
					campo.setText("");
				}catch(EscolaException f) {
					JOptionPane.showMessageDialog(m,f,"Erro",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		if(flag == 0) 
			campo.setText("");
	}
}
