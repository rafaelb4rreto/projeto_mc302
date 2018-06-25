import javax.swing.*;


public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[] classes; 
	public Login(Object[] o,Diretor d) {
		
		classes = o;
		
	}
	
	public int classSelection(Diretor d) {
		
		int answer = JOptionPane.showOptionDialog(null,"Que area gostaria de fazer login?","Tela de inicio", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,null, classes, classes[2]);
		
		return answer;
	}
	
	
	
	
	
}