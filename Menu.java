import javax.swing.*;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

public class Menu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel materias = new JLabel("Que materias você deseja cursar: ");
	private Aluno a;
	private Diretor d;
	
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor) {
		super("Menu");
		
		
		
			JFrame dados = new JFrame();
			Container c = dados.getContentPane();
			c.setLayout(new FlowLayout());
			
			JButton b1 = new JButton("Matricular Aluno");
			JButton b2 = new JButton("Advertir Aluno");
			JButton b3 = new JButton("Suspender Aluno");
			JButton b4 = new JButton("Expulsar Aluno");
			JButton b5 = new JButton("Contratar Professor");
			JButton b6 = new JButton("Demitir Professor");
			JButton b7 = new JButton("Atribuir Materia");
			JButton b8 = new JButton("Desatribuir Materia");
			JButton b9 = new JButton("Abrir Materia");
			JButton b10 = new JButton("Fechar Materia");
			JButton b11 = new JButton("Enviar Mensagem");
			JButton b12 = new JButton("Pagar Professor");
			JButton b13 = new JButton("Receber Mensalidade");
			
			c.add(b1);
			c.add(b2);
			c.add(b3);
			c.add(b4);
			c.add(b5);
			c.add(b6);
			c.add(b7);
			c.add(b8);
			c.add(b9);
			c.add(b10);
			c.add(b11);
			c.add(b12);
			c.add(b13);
			
			b2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = JOptionPane.showInputDialog("Que aluno sera advertido?");
					
					for(int i = 0;i < diretor.getAlunos().size();i++) {
						if(diretor.getAlunos().get(i).getNome().equals(s)) {
							try {
								diretor.advertirAluno(diretor.getAlunos().get(i));
							}catch(EscolaException t) {
								JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
							}
						}
							
					}
				}	
			});
			
			b3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = JOptionPane.showInputDialog("Que aluno sera suspenso?");
					
					for(int i = 0;i < diretor.getAlunos().size();i++) {
						if(diretor.getAlunos().get(i).getNome().equals(s)) {
							try {
								diretor.suspenderAluno(diretor.getAlunos().get(i));
								}catch(EscolaException t) {
								JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
							}
						}
							
					}
				}	
			});
			
			b4.addActionListener (	new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = JOptionPane.showInputDialog("Que aluno sera expulso?");
					
					for(int i = 0;i < diretor.getAlunos().size();i++) {
						if(diretor.getAlunos().get(i).getNome().equals(s)) {
							try {
								diretor.expulsarAluno(diretor.getAlunos().get(i));
								//System.out.println(diretor.getAlunos());
								}catch(EscolaException t) {
								JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
							}
						}
							
					}
				}	
			});
			
			b5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame newFrame = new JFrame("Dados Cadastrais");
					Container newc = newFrame.getContentPane();
					newc.setLayout(new GridLayout());
					JTextField campoSalario = new JTextField(4);
					JTextField campoNome = new JTextField(20);
					JTextField campoIdade = new JTextField(2);
					JTextField campoSexo = new JTextField(1);
					JTextField campoDataNascimento = new JTextField(10);
					JTextField campoSenha = new JTextField(10);
					JTextField campoSala = new JTextField(4);
					
					JLabel nome = new JLabel("Nome");
					JLabel idade = new JLabel("Idade");
					JLabel sexo = new JLabel("Sexo");
					JLabel data = new JLabel("Data de nascimento");
					JLabel senha = new JLabel("Senha");
					JLabel sala = new JLabel("Sala");
					JLabel salario = new JLabel("Salario");
					
					nome.setLabelFor(campoNome);
					idade.setLabelFor(campoIdade);
					sexo.setLabelFor(campoSexo);
					data.setLabelFor(campoDataNascimento);
					senha.setLabelFor(campoSenha);
					sala.setLabelFor(campoSala);
					salario.setLabelFor(campoSalario);
					
					newc.add(nome);
					newc.add(campoNome);
					newc.add(idade);
					newc.add(campoIdade);
					newc.add(sexo);
					newc.add(campoSexo);
					newc.add(data);
					newc.add(campoDataNascimento);
					newc.add(senha);
					newc.add(campoSenha);
					newc.add(sala);
					newc.add(campoSala);
					newc.add(salario);
					newc.add(campoSalario);
					
					JButton but = new JButton("Cadastrar");
					newc.add(but);
					
					
					but.addActionListener(	new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {		
							diretor.contratarProfessor(campoNome.getText(), Integer.parseInt(campoIdade.getText()),campoSexo.getText().charAt(0),campoDataNascimento.getText(),campoSenha.getText(),campoSala.getText(),Integer.parseInt(campoSalario.getText()));
						}
					});
					
					newFrame.pack();
					newFrame.show();					
				}	
			});
			
			
			b6.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = JOptionPane.showInputDialog("Que professor sera demitido?");
					int index = 0;
					int i;
					while(diretor.getProfessores().size() > 0) //ARRUMAR - EXCECAO DE CONCORRENCIA, POR CAUSA DO LOOP
						if(diretor.getProfessores().get(index).getNome().equals(s)) {
							try {
								diretor.demitirProfessor(diretor.getProfessores().get(index));
							}catch(EscolaException t) {
								JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
							}
						}
						else
							index++;
							
							
					}	
				});
			
			b9.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Abertura de Materia");
					materia.setSize(800, 600);
					materia.setLocationRelativeTo(null);
					JTextField nometxt = new JTextField(10);
					JLabel nome = new JLabel("Nome: ");
					nome.setLabelFor(nometxt);

					JTextField codtxt = new JTextField(5);
					JLabel cod = new JLabel("Codigo: ");
					cod.setLabelFor(codtxt);

					JTextField credtxt = new JTextField(2);
					JLabel cred = new JLabel("Creditos: ");
					cred.setLabelFor(credtxt);
					
					JTextField salatxt = new JTextField(5);
					JLabel sala = new JLabel("Sala: ");
					sala.setLabelFor(salatxt);
					
					JTextField hortxt = new JTextField(5);
					JLabel hor = new JLabel("Horario: ");
					hor.setLabelFor(hortxt);
					
					JTextField diatxt = new JTextField(10);
					JLabel dia = new JLabel("Dia: ");
					dia.setLabelFor(diatxt);

					JTextField captxt = new JTextField(3);
					JLabel cap = new JLabel("Capacidade: ");
					cap.setLabelFor(captxt);

					JTextField emetxt = new JTextField(20);
					JLabel eme = new JLabel("Ementa: ");
					eme.setLabelFor(emetxt);

					JButton b = new JButton("Adicionar");
					materia.getContentPane().setLayout(new FlowLayout());

					materia.getContentPane().add(nome);
					materia.getContentPane().add(nometxt);
					materia.getContentPane().add(cod);
					materia.getContentPane().add(codtxt);
					materia.getContentPane().add(cred);
					materia.getContentPane().add(credtxt);
					materia.getContentPane().add(sala);
					materia.getContentPane().add(salatxt);
					materia.getContentPane().add(hor);
					materia.getContentPane().add(hortxt);
					materia.getContentPane().add(dia);
					materia.getContentPane().add(diatxt);
					materia.getContentPane().add(cap);
					materia.getContentPane().add(captxt);
					materia.getContentPane().add(eme);
					materia.getContentPane().add(emetxt);
					materia.getContentPane().add(b);

					
					b.addActionListener(new Listeners.AbreMateriaListener(diretor,materia,nometxt,codtxt,credtxt,salatxt,hortxt,diatxt,captxt,emetxt));

					
					//materia.pack();
					materia.show();
	 			}
			});
			
			b10.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Fechamento de Materia");
					
					materia.setSize(400, 300);
					materia.setLocationRelativeTo(null);

					JTextField codtxt = new JTextField(5);
					JLabel cod = new JLabel("Digite o Codigo da Materia: ");
					cod.setLabelFor(codtxt);

					JButton b = new JButton("Fechar Materia");
					materia.getContentPane().setLayout(new FlowLayout());

					materia.getContentPane().add(cod);
					materia.getContentPane().add(codtxt);
					materia.getContentPane().add(b);

					
					b.addActionListener(new Listeners.FechaMateriaListener(diretor,materia,codtxt));

		
		
		
		
		
		
		
		
		
		/*			Professor novo_professor = new Professor(nome, idade, sexo, dataNascimento, senha, sala, salario);

		 * 			campoSerie = new JTextField(1);
			
			nome = new JLabel("Nome: ");
			idade = new JLabel("Idade: ");
			sexo = new JLabel("Sexo: ");
			data = new JLabel("Data de nascimento: ");
			senha = new JLabel("Senha: ");
			serie = new JLabel("Serie: ");
			
			nome.setLabelFor(campoNome);
			idade.setLabelFor(campoIdade);
			sexo.setLabelFor(campoSexo);
			data.setLabelFor(campoDataNascimento);
			senha.setLabelFor(campoSenha);
			serie.setLabelFor(campoSerie);
			
			dados.getContentPane().add(nome);
			dados.getContentPane().add(campoNome);
			dados.getContentPane().add(idade);
			dados.getContentPane().add(campoIdade);
			dados.getContentPane().add(sexo);
			dados.getContentPane().add(campoSexo);
			dados.getContentPane().add(data);
			dados.getContentPane().add(campoDataNascimento);
			dados.getContentPane().add(senha);
			dados.getContentPane().add(campoSenha);
			dados.getContentPane().add(serie);
			dados.getContentPane().add(campoSerie);*/
			
			dados.pack();
			dados.show();
	
	}
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor,Aluno aluno) {
		super("Menu");
		
		a = aluno;
		d = diretor; 
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		JButton botao1 = new JButton("Adicionar Materia");
		JButton botao2 = new JButton("Remover Materia");
		JButton botao3 = new JButton("Mandar Mensagem");
		
		c.add(botao1);
		c.add(botao2);
		c.add(botao3);
		
		this.pack();
		this.show();
		
		//c.getComponent(0).setSize(100,100);
		//c.getComponent(1).setSize(100,100);
		//c.getComponent(2).setSize(100,100);
		
		botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame materia = new JFrame("Escolha de Materias");
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Adicionar");
				materia.getContentPane().setLayout(new FlowLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new AdicionaMateriaListener(materia,txt,diretor,aluno));

				
				materia.pack();
				materia.show();
 			}
		});

		botao2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame materia = new JFrame("Escolha de Materias");
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Remover");
				materia.getContentPane().setLayout(new FlowLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new RemoveMateriaListener(materia,txt,diretor,aluno));
				
				materia.pack();
				materia.show();
			}
			
		});

	}
	
}
