import javax.swing.*;

public class MyFrame1 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame1() {
		
	super("Escola X");
	final JLabel label = new JLabel("Bem vindo!");
	this.getContentPane().add(label);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
	}

	
}
