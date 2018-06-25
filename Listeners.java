import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


	
public class Listeners  {

	public static class AbreMateriaListener implements ActionListener{
		
		private Diretor d;
		private JTextField nome, cod, cred, sala, hor, dia, cap, eme;
		
		
		public AbreMateriaListener(Diretor d, JFrame j, JTextField nome, JTextField cod, JTextField cred, JTextField sala,
				JTextField hor, JTextField dia, JTextField cap, JTextField eme) {

			this.d = d;
			this.nome = nome;
			this.cod = cod;
			this.cred = cred;
			this.sala = sala;
			this.hor = hor;
			this.dia = dia;
			this.cap = cap;
			this.eme = eme;
		}


		public void actionPerformed(ActionEvent arg0) {
			
			try{
				d.abrirMateria(nome.getText(), cod.getText(), Integer.parseInt(cred.getText()), sala.getText(), hor.getText(), Dia.valueOf(dia.getText().toUpperCase()), Integer.parseInt(cap.getText()), eme.getText());
			
				JOptionPane.showMessageDialog(null, "Materia "+nome.getText()+" foi aberta no sistema!", null, JOptionPane.INFORMATION_MESSAGE);
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Os campos Creditos e Capcidade esperam numeros!", null, JOptionPane.ERROR_MESSAGE);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Voce digitou o dia de forma incorreta!", null, JOptionPane.ERROR_MESSAGE);
			}
			
			for(Materia m: d.getMaterias())System.out.println(m.getNome());
		}

		
		
	}

	public static class LoginDiretorListener implements ActionListener {

		private JTextField campo1,campo2;
		private Diretor d;
		
		public LoginDiretorListener(JTextField Id,JTextField aut,Diretor d) {
			this.campo1 = Id;
			this.campo2 = aut;
			this.d = d;
		}

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

	public static class LoginAlunoListener implements ActionListener{

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
	
	public static class LoginProfessorListener implements ActionListener{

		private JTextField campo1,campo2;
		private Diretor d;
		
		public LoginProfessorListener(JTextField Id,JTextField aut,Diretor d) {
			this.campo1 = Id;
			this.campo2 = aut;
			this.d = d;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int flag = 0;
			for(int i = 0;i < d.getProfessores().size();i++) {
				if(d.getProfessores().get(i).getNome().equals(campo1.getText())) {
					if(d.getProfessores().get(i).getSenha().equals(campo2.getText())) {
						Professor professor = d.getProfessores().get(i);
						new Menu(d,professor);
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

	public static class AdicionaMateriaListener implements ActionListener{
		private JTextField campo;
		private Diretor d;
		private Aluno aluno;
		private JFrame m;
		
		public AdicionaMateriaListener(JFrame materia,JTextField campo,Diretor d,Aluno a){
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
						aluno.adicionarMateria(d.getMaterias().get(i));
						JOptionPane.showMessageDialog(null, "Materia "+d.getMaterias().get(i).getNome()+" adicionada", null, JOptionPane.INFORMATION_MESSAGE);
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

	public static class RemoveMateriaListener implements ActionListener{
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
					JOptionPane.showMessageDialog(null, "Materia "+d.getMaterias().get(i).getNome()+" removida", null, JOptionPane.INFORMATION_MESSAGE);
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

	public static class FechaMateriaListener implements ActionListener{
		
		private JTextField cod;
		private Diretor d;

		
		public FechaMateriaListener(Diretor dir,JFrame materia,JTextField cod){
			
			this.cod = cod;
			this.d = dir;

		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Materia mat;
			try{
				for(Materia m:d.getMaterias()){
			
			
					if(m.getCodigo().equalsIgnoreCase(cod.getText())) {
						mat = m;
						d.fecharMateria(mat);
						JOptionPane.showMessageDialog(null, "Materia fechada com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
				throw new EscolaException();
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "Materia nao encontrada!\nConfira o codigo", null, JOptionPane.ERROR_MESSAGE);
			}		
			
		}
	}





}