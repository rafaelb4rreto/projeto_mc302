import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MatriculaListener implements ActionListener{
	
	String nome,idade,sexo,data,senha,serie;
	Diretor d;
	
	MatriculaListener(String nome,String idade,String sexo,String data,String senha,String serie,Diretor d){
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.data = data;
		this.senha = senha;
		this.serie = serie;
		this.d = d;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int i = 0;
		/*int j = Integer.parseInt(serie);
		char k = sexo.charAt(0);
			d.matricularAluno(nome,i,k, data, senha, j);*/
		}
		
	}

