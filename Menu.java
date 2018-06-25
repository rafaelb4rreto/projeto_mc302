import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Menu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor,Professor professor) {
		
		super("Professor");
		
		GridLayout grid;
		
		JLabel nome, ra, salario, pago;
		Component[][] aula_grid;
		
		String 	   horario_info;
		String	   materia_info = "";
		int		   linha_horario;
		
		JButton b1 = new JButton("Editar Ementa");
		JButton b2 = new JButton("Adicionar Notas");
		JButton b3 = new JButton("Calcular Media da Turma");
		
		Materia ma_buff = null;
		
		nome 	= new JLabel();		
		ra 		= new JLabel("RA: " + professor.getRA());
		salario = new JLabel("Salario: " + professor.getSalario());
		pago 	= new JLabel();
		
		grid 	  = new GridLayout(0, 6);	
		aula_grid = new AulaButton[5][5];
		
		if (professor.getSexo() == 'M')
			nome.setText("Professor " + professor.getNome());
		else if (professor.getSexo() == 'F')
			nome.setText("Professora " + professor.getNome());
		else
			nome.setText("Professor(a) " + professor.getNome());
		
		if (professor.isPago() == true) {
			pago.setText(" Salário PAGO ");
			pago.setBorder(BorderFactory.createLineBorder(Color.green));
		}else {
			pago.setText(" Salário NÃO PAGO ");
			pago.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		
		this.getContentPane().setLayout(grid);
		this.getContentPane().add(nome);
		this.getContentPane().add(ra);
		this.getContentPane().add(salario);
		this.getContentPane().add(pago);
		this.getContentPane().add(new JLabel(""));
		this.getContentPane().add(new JLabel(""));
		
		this.getContentPane().add(b1);
		this.getContentPane().add(b2);
		this.getContentPane().add(b3);
		this.getContentPane().add(new JLabel(""));
		this.getContentPane().add(new JLabel(""));
		this.getContentPane().add(new JLabel(""));

		
		
		
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame et = new JFrame("Editar Ementa");
				Container ct = et.getContentPane();
				ct.setLayout(new FlowLayout());
				
				JTextField materia = new JTextField(5);
				JTextArea ementa = new JTextArea(5,20);
				
				JLabel labelMateria = new JLabel("Materia: ");
				JLabel labelEmenta = new JLabel("Nova Ementa: ");
				
				labelMateria.setLabelFor(materia);
				labelEmenta.setLabelFor(ementa);
				
				ct.add(labelMateria);
				ct.add(materia);
				ct.add(labelEmenta);
				ct.add(ementa);
				
				JButton b = new JButton("OK");
				ct.add(b);
				
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {						
						for(int i = 0;i < professor.getMaterias().size();i++) {
							if(professor.getMaterias().get(i).getCodigo().equals(materia.getText())) {
								try {
									professor.editarEmenta(ementa.getText(),professor.getMaterias().get(i));
									JOptionPane.showMessageDialog(null, "Ementa alterada com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
									return;
								}catch(EscolaException t) {
									JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
								}
							}
								
						}
						
						
						
					}		
				});
				
				et.setSize(500,300);
				et.setLocationRelativeTo(null);
				et.show();
				
			}
				
		});
		
		
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame et = new JFrame("Adicao de Notas");
				Container ct = et.getContentPane();
				ct.setLayout(new FlowLayout());
				
				JTextField nota = new JTextField(4);
				JTextField materia = new JTextField(10);
				JTextField aluno = new JTextField(6);
				
				
				JLabel labelMateria = new JLabel("Codigo da Materia: ");
				JLabel labelAluno = new JLabel("RA do Aluno: ");
				JLabel labelNota = new JLabel("Nota: ");
				
				labelMateria.setLabelFor(materia);
				labelAluno.setLabelFor(aluno);
				labelNota.setLabelFor(nota);
				
				ct.add(labelMateria);
				ct.add(materia);
				ct.add(labelAluno);
				ct.add(aluno);
				ct.add(labelNota);
				ct.add(nota);
				
				JButton b = new JButton("OK");
				ct.add(b);
				
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {						
						for(int i = 0;i < professor.getMaterias().size();i++) {
							if(professor.getMaterias().get(i).getCodigo().equals(materia.getText())) {
								for(int j = 0;j < professor.getMaterias().get(i).getAlunosCadastrados().size();j++) {
									if(professor.getMaterias().get(i).getAlunosCadastrados().get(j).getAluno().getRA() == Long.parseLong(aluno.getText())) {
										try {
											professor.adicionarNotas(professor.getMaterias().get(i).getAlunosCadastrados().get(j).getAluno(), professor.getMaterias().get(i), Integer.parseInt(nota.getText()));
											JOptionPane.showMessageDialog(null, "A nota foi atribuida ao aluno com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
											return;
										}catch(EscolaException t) {
											JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
										}
									}
								}
							}
								
						}	
					}		
				});	
				
				et.setSize(350,300);
				et.show();
			}
		});
		
		
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame nf = new JFrame("Media Materia");
				Container c = nf.getContentPane();
				c.setLayout(new FlowLayout());
				
				JTextField tf = new JTextField(5) ;
				JLabel jl = new JLabel("Cod. da Materia: ");
				JButton jb = new JButton("OK");
				
				jl.setLabelFor(tf);
				
				c.add(jl);
				c.add(tf);
				c.add(jb);
				
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						for(int i = 0;i < professor.getMaterias().size();i++) {
							if(professor.getMaterias().get(i).getCodigo().equals(tf.getText()))
								try {
									DecimalFormat media2f = new DecimalFormat("#.##");
									float media = professor.mediaMateria(professor.getMaterias().get(i));
									JOptionPane.showMessageDialog(null, "A media nesse materia eh: "+media2f.format(media)+" !", null, JOptionPane.INFORMATION_MESSAGE);
									return;
								}catch(EscolaException t) {
									JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
								}
						}
						
					}
					
				});
				
				nf.setSize(200,200);
				nf.setLocationRelativeTo(null);
				nf.show();
						
				
			}
			
		});
		
		this.setLocationRelativeTo(null);
		this.pack();
		this.show();

	}
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor) {
		super("Menu");
		
		
		
			JFrame dados = new JFrame("Diretor");
			Container c = dados.getContentPane();
			c.setLayout(new FlowLayout());
			dados.setSize(300,450);
			dados.setLocationRelativeTo(null);
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
			JButton b11 = new JButton("Pagar Professor");
			JButton b12 = new JButton("Ver Escola");
			JButton b13 = new JButton("Salvar Dados");
			JButton b14 = new JButton("Carregar Dados");
			
			
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
			c.add(b14);
			
			
			dados.show();
		
			b1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Matricular Aluno");
					materia.setSize(800, 300);
					materia.setLocationRelativeTo(null);
					
					JTextField nometxt = new JTextField(10);
					JLabel nome = new JLabel("Nome: ");
					nome.setLabelFor(nometxt);

					JTextField idatxt = new JTextField(5);
					JLabel ida = new JLabel("Idade: ");
					ida.setLabelFor(idatxt);

					JRadioButton m = new JRadioButton("Masculino");
					JRadioButton f = new JRadioButton("Feminino");
					JLabel sex = new JLabel("Sexo: ");
					sex.setLabelFor(m);
					ButtonGroup group = new ButtonGroup();
					group.add(m);
					group.add(f);
					
					JTextField datatxt = new JTextField(5);
					JLabel data = new JLabel("Data de nascimento: ");
					data.setLabelFor(datatxt);
					
					JTextField sentxt = new JTextField(5);
					JLabel sen = new JLabel("Senha: ");
					sen.setLabelFor(sentxt);
					
					JTextField sertxt = new JTextField(10);
					JLabel ser = new JLabel("Serie: ");
					ser.setLabelFor(sertxt);

					JButton b = new JButton("Matricular");
					materia.getContentPane().setLayout(new FlowLayout());

					materia.getContentPane().add(nome);
					materia.getContentPane().add(nometxt);
					materia.getContentPane().add(ida);
					materia.getContentPane().add(idatxt);
					materia.getContentPane().add(sex);
					materia.getContentPane().add(m);
					materia.getContentPane().add(f);
					materia.getContentPane().add(data);
					materia.getContentPane().add(datatxt);
					materia.getContentPane().add(sen);
					materia.getContentPane().add(sentxt);
					materia.getContentPane().add(ser);
					materia.getContentPane().add(sertxt);
					materia.getContentPane().add(b);

					
					b.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							
							try {
								char sexo;
								if(m.isSelected()) sexo = 'M';
								else sexo = 'F';
								diretor.matricularAluno(nometxt.getText(), Integer.parseInt(idatxt.getText()), sexo, datatxt.getText(), sentxt.getText(), Integer.parseInt(sertxt.getText()));
								JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Dados incorretos\nConfira os campos", null, JOptionPane.ERROR_MESSAGE);
							}
						
						}
						
						
					});

					
					//materia.pack();
					materia.show();
	 			}
			});	
		
			
			b2.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Que Aluno recebera uma advertencia?");
					
					materia.setSize(500, 300);
					materia.setLocationRelativeTo(null);

					JComboBox<String> jc = new JComboBox<String>();
					
					
					JLabel aluno = new JLabel("Selecione o Aluno: ");
					aluno.setLabelFor(jc);
					
					for(Aluno p: diretor.getAlunos()) 	jc.addItem(p.getNome());

					JButton b = new JButton("Advertir");
					
					materia.getContentPane().setLayout(new FlowLayout());
					materia.getContentPane().add(aluno);
					materia.getContentPane().add(jc);
					materia.getContentPane().add(b);
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try{
								for(Aluno p: diretor.getAlunos()) {
								
									if(p.getNome().equals(jc.getSelectedItem())) {
									
										diretor.advertirAluno(p);
										JOptionPane.showMessageDialog(null, "Aluno "+p.getNome()+" recebeu uma advertencia!", null, JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								
								
								}	
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
							}		
							
						}
					});
					//materia.pack();
					materia.show();
	 			}
			});
			
			b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Que Aluno recebera uma suspensao?");
					
					materia.setSize(500, 300);
					materia.setLocationRelativeTo(null);

					JComboBox<String> jc = new JComboBox<String>();
					
					
					JLabel aluno = new JLabel("Selecione o Aluno: ");
					aluno.setLabelFor(jc);
					
					for(Aluno p: diretor.getAlunos()) 	jc.addItem(p.getNome());

					JButton b = new JButton("Suspender");
					
					materia.getContentPane().setLayout(new FlowLayout());
					materia.getContentPane().add(aluno);
					materia.getContentPane().add(jc);
					materia.getContentPane().add(b);
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try{
								for(Aluno p: diretor.getAlunos()) {
								
									if(p.getNome().equals(jc.getSelectedItem())) {
									
										diretor.suspenderAluno(p);
										JOptionPane.showMessageDialog(null, "Aluno "+p.getNome()+" recebeu uma suspensao!", null, JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								
								
								}	
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
							}		
							
						}
					});
					//materia.pack();
					materia.show();
	 			}
			});
			
			b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Que Aluno sera expulso?");
					
					materia.setSize(500, 300);
					materia.setLocationRelativeTo(null);

					JComboBox<String> jc = new JComboBox<String>();
					
					
					JLabel aluno = new JLabel("Selecione o Aluno: ");
					aluno.setLabelFor(jc);
					
					for(Aluno p: diretor.getAlunos()) 	jc.addItem(p.getNome());

					JButton b = new JButton("Expulsar");
					
					materia.getContentPane().setLayout(new FlowLayout());
					materia.getContentPane().add(aluno);
					materia.getContentPane().add(jc);
					materia.getContentPane().add(b);
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try{
								for(Aluno p: diretor.getAlunos()) {
								
									if(p.getNome().equals(jc.getSelectedItem())) {
									
										diretor.expulsarAluno(p);
										JOptionPane.showMessageDialog(null, "Aluno "+p.getNome()+" foi expulso da escola!", null, JOptionPane.INFORMATION_MESSAGE);
										return;
									}
									
								
								}
								throw new EscolaException("Aluno ja expulso da escola");
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
							}		
							
						}
					});
					//materia.pack();
					materia.show();
	 			}
			});
			
			b5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					JFrame newFrame = new JFrame("Dados Cadastrais");
					newFrame.setSize(650, 200);
					newFrame.setLocationRelativeTo(null);
					Container newc = newFrame.getContentPane();
					newc.setLayout(new FlowLayout());
					JTextField campoSalario = new JTextField(4);
					JTextField campoNome = new JTextField(20);
					JTextField campoIdade = new JTextField(2);
					JTextField campoDataNascimento = new JTextField(10);
					JTextField campoSenha = new JTextField(10);
					JTextField campoSala = new JTextField(4);
					
					JLabel nome = new JLabel("Nome");
					JLabel idade = new JLabel("Idade");
					JRadioButton m = new JRadioButton("Masculino");
					JRadioButton f = new JRadioButton("Feminino");
					JLabel sexo = new JLabel("Sexo");
					ButtonGroup group = new ButtonGroup();
					group.add(m);
					group.add(f);
	
					JLabel data = new JLabel("Data de nascimento");
					JLabel senha = new JLabel("Senha");
					JLabel sala = new JLabel("Sala");
					JLabel salario = new JLabel("Salario");
					
					nome.setLabelFor(campoNome);
					idade.setLabelFor(campoIdade);
					sexo.setLabelFor(m);
					data.setLabelFor(campoDataNascimento);
					senha.setLabelFor(campoSenha);
					sala.setLabelFor(campoSala);
					salario.setLabelFor(campoSalario);
					
					newc.add(nome);
					newc.add(campoNome);
					newc.add(idade);
					newc.add(campoIdade);
					newc.add(sexo);
					newc.add(m);
					newc.add(f);
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

						public void actionPerformed(ActionEvent arg0) {
							
							try {
								char sexo;
								if(m.isSelected()) sexo = 'M';
								else sexo = 'F';
								diretor.contratarProfessor(campoNome.getText(), Integer.parseInt(campoIdade.getText()), sexo, campoDataNascimento.getText(), campoSenha.getText(),campoSala.getText(), Integer.parseInt(campoSalario.getText()));
								JOptionPane.showMessageDialog(null, "Professor contratado com sucesso", null, JOptionPane.INFORMATION_MESSAGE);
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Dados incorretos\nConfira os campos", null, JOptionPane.ERROR_MESSAGE);
							}
						
						}
					});
			//		newFrame.pack();
					newFrame.show();					
				}	
			});
			
			
			b6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Que Professor sera demitido?");
					
					materia.setSize(500, 300);
					materia.setLocationRelativeTo(null);

					JComboBox<String> jc = new JComboBox<String>();
					
					
					JLabel prof = new JLabel("Selecione o Professor: ");
					prof.setLabelFor(jc);
					
					for(Professor k: diretor.getProfessores()) 	jc.addItem(k.getNome());

					JButton b = new JButton("Demitir");
					
					materia.getContentPane().setLayout(new FlowLayout());
					materia.getContentPane().add(prof);
					materia.getContentPane().add(jc);
					materia.getContentPane().add(b);
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try{
								for(Professor pr: diretor.getProfessores()) {
								
									if(pr.getNome().equals(jc.getSelectedItem())) {
									
										diretor.demitirProfessor(pr);
										JOptionPane.showMessageDialog(null, "Professor "+pr.getNome()+" foi demitido da escola!", null, JOptionPane.INFORMATION_MESSAGE);
										return;
									}
									
								
								}
								throw new EscolaException("Professor ja demitido da escola");
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
							}		
							
						}
					});
					//materia.pack();
					materia.show();
	 			}
			});
			
			b7.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame jf = new JFrame("Atribuicao");
					jf.setSize(600, 200);
					jf.setLocationRelativeTo(null);
					Container con = jf.getContentPane();
					con.setLayout(new GridLayout());
					
					JTextField codMat = new JTextField(5);
					JTextField RAp = new JTextField(10);
					JLabel codigo = new JLabel("Codigo da materia");
					JLabel pr = new JLabel("Professor");
					
					codigo.setLabelFor(codMat);
					pr.setLabelFor(RAp);
					
					con.add(codigo);
					con.add(codMat);
					con.add(pr);
					con.add(RAp);
					
					JButton jb = new JButton("PRONTO");
					
					con.add(jb);
					

					jb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							for(int i = 0;i < diretor.getProfessores().size();i++) {
								if(diretor.getProfessores().get(i).getNome().equals(RAp.getText())) {
									for(int j = 0;j < diretor.getMaterias().size();j++) {
										if(diretor.getMaterias().get(j).getCodigo().equals(codMat.getText())) {
											try {
												diretor.atribuirMateriaAUmProfessor(diretor.getProfessores().get(i),diretor.getMaterias().get(j));
												JOptionPane.showMessageDialog(null, "Materia "+diretor.getMaterias().get(j).getNome()+" atribuida ao Professor " +diretor.getProfessores().get(i).getNome(), null, JOptionPane.INFORMATION_MESSAGE);
											}catch(EscolaException t) {
												JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
											}
										}
									}
								}
							}
								
						}	
					});

				//	jf.pack();
					jf.show();	
				}
			});
					
					
			b8.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					JFrame jf = new JFrame("Atribuicao");
					jf.setSize(600, 200);
					jf.setLocationRelativeTo(null);
					Container con = jf.getContentPane();
					con.setLayout(new GridLayout());
					
					JTextField codMat = new JTextField(5);
					JTextField RAp = new JTextField(10);
					JLabel codigo = new JLabel("Codigo da materia");
					JLabel pr = new JLabel("Professor");
					
					codigo.setLabelFor(codMat);
					pr.setLabelFor(RAp);
					
					con.add(codigo);
					con.add(codMat);
					con.add(pr);
					con.add(RAp);
					
					JButton jb = new JButton("PRONTO");
					
					con.add(jb);
					jb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							for(int i = 0;i < diretor.getProfessores().size();i++) {
								if(diretor.getProfessores().get(i).getNome().equals(RAp.getText())) {
									for(int j = 0;j < diretor.getMaterias().size();j++) {
										if(diretor.getMaterias().get(j).getCodigo().equals(codMat.getText())) {
											try {
												diretor.desatribuirMateriaAUmProfessor(diretor.getProfessores().get(i),diretor.getMaterias().get(j));
												JOptionPane.showMessageDialog(null, "Materia "+diretor.getMaterias().get(j).getNome()+" desatribuida do Professor " +diretor.getProfessores().get(i).getNome(), null, JOptionPane.INFORMATION_MESSAGE);
											}catch(EscolaException t) {
												JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
											}
										}
									}
								}
							}
						}
					});
					
			//		jf.pack();
					jf.show();	
					}	
				});	

			
			
			b9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Abertura de Materia");
					materia.setSize(550, 300);
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
			

					materia.show();
	
				}
			});
			
			
			b11.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Pagar Professor");
					
					materia.setSize(500, 300);
					materia.setLocationRelativeTo(null);

					JComboBox<String> jc = new JComboBox<String>();
					
					
					JLabel prof = new JLabel("Selecione o Professor: ");
					prof.setLabelFor(jc);
					
					for(Professor p: diretor.getProfessores()) 	jc.addItem(p.getNome());

					JButton b = new JButton("Pagar");
					
					materia.getContentPane().setLayout(new FlowLayout());
					materia.getContentPane().add(prof);
					materia.getContentPane().add(jc);
					materia.getContentPane().add(b);
					b.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							try{
								for(Professor p: diretor.getProfessores()) {
								
									if(p.getNome().equals(jc.getSelectedItem())) {
									
										diretor.pagarProfessor(p);
										JOptionPane.showMessageDialog(null, "Professor "+p.getNome()+" pago com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
										return;
									}
								
								
								}	
							}catch(Exception e1){
								JOptionPane.showMessageDialog(null, "Este Professor ja recebeu seu salario neste mes!", null, JOptionPane.ERROR_MESSAGE);
							}		
							
						}
					});
					//materia.pack();
					materia.show();
	 			}
			});
			
			
			b12.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Ver Escola");
					
					materia.getContentPane().setLayout(new GridLayout(0,2));
	//				materia.setSize(800, 400);
					materia.setLocationRelativeTo(null);

					JLabel prof = new JLabel("Professores");
					JTextArea jprof = new JTextArea(5,3);
		//			prof.setLabelFor(jprof);
					for(Professor p : diretor.getProfessores()) {
						jprof.append("*Nome: "+ p.getNome()+ " -  RA: " + p.getRA()+"\n\n") ;
					}

			//		jprof.append(profs);
					materia.add(prof);
					materia.add(jprof);
				//	jprof.setText(profs);
				
					
					JLabel al = new JLabel("Alunos");
					
					String als = "";
					for(Aluno a : diretor.getAlunos()) {
						als += "*Nome: "+ a.getNome()+ " -  RA: " + a.getRA()+"\n\n" ;
					}
					JTextArea jal = new JTextArea();
					materia.add(al);
					materia.add(jal);
					jal.append(als);
					//jal.setText(als);
					
					JLabel mat = new JLabel("Materias");

					//mat.setLabelFor(jmat);
					String mats = "";
					for(Materia m : diretor.getMaterias()) {
						mats += m + "\n\n" ;
					}
					JTextArea jmat = new JTextArea();
					materia.add(mat);
					materia.add(jmat);
					jmat.append(mats);
					//jmat.setText(mats);
					
					materia.pack();
					materia.show();
					
					
				

	 			}
			});
			
			//Salvar Dados
			b13.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							
					try{
						diretor.salvarDados();
						JOptionPane.showMessageDialog(null, "Os dados da escola foram salvos com sucesso!\nConfira o arquivo 'escola.txt' na pasta do projeto", null, JOptionPane.INFORMATION_MESSAGE);
						return;
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
					}		
	 			}
			});
			
			//Carregar Dados
			b14.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
							
					try{							
						diretor.carregarDados();
						JOptionPane.showMessageDialog(null, "Os dados da escola foram carregados com sucesso!", null, JOptionPane.INFORMATION_MESSAGE);
						return;
						
					}catch(Exception e1){
						JOptionPane.showMessageDialog(null, e1, null, JOptionPane.ERROR_MESSAGE);
					}		
	 			}
			});
			
	}
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor,Aluno aluno) {
		super("Aluno");
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());

		JButton botao1 = new JButton("Adicionar Materia");
		JButton botao2 = new JButton("Remover Materia");
		
		/*Container[][] aula_grid = new AulaButton[5][5];
		String 	   horario_info;
		String	   materia_info = "";
		int		   linha_horario;
		Materia ma_buff = null;*/
		
		c.add(botao1);
		c.add(botao2);
			botao1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame materia = new JFrame("Escolha de Materias");
				materia.setSize(600, 200);
				materia.setLocationRelativeTo(null);
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Adicionar");
				materia.getContentPane().setLayout(new GridLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new Listeners.AdicionaMateriaListener(materia,txt,diretor,aluno));
				
				
	//			materia.pack();
				materia.show();
 			}
		});

		botao2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame materia = new JFrame("Escolha de Materias");
				materia.setSize(300, 200);
				materia.setLocationRelativeTo(null);
				JTextField txt = new JTextField(10);
				JLabel cod = new JLabel("Codigo da materia: ");
				cod.setLabelFor(txt);
				JButton b = new JButton("Remover");
				materia.getContentPane().setLayout(new FlowLayout());

				materia.getContentPane().add(cod);
				materia.getContentPane().add(txt);
				materia.getContentPane().add(b);
				
				b.addActionListener(new Listeners.RemoveMateriaListener(materia,txt,diretor,aluno));
				
				
				materia.pack();
				materia.show();
			}
			
		});
		
		this.show();
		
		
		
	}
	
}
