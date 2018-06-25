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
	private Professor p;
	private Diretor d;
	
	
	
	@SuppressWarnings("deprecation")
	public Menu(Diretor diretor,Professor professor) {
		JFrame dados = new JFrame();
		Container c = dados.getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("Editar Ementa");
		JButton b2 = new JButton("Adicionar Notas");
		JButton b3 = new JButton("Calcular Media da Turma");
		
		c.add(b1);
		c.add(b2);
		c.add(b3);
		
		b1.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame et = new JFrame("Editar Ementa");
				Container ct = et.getContentPane();
				ct.setLayout(new FlowLayout());
				
				JTextField materia = new JTextField(5);
				JTextField ementa = new JTextField(30);
				
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
		
		dados.setSize(200,300);
		dados.setLocationRelativeTo(null);
		dados.show();

	}
	
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
			JButton b11 = new JButton("Pagar Professor");
			JButton b12 = new JButton("Receber Mensalidade");
			
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
			
			dados.pack();
			dados.show();
		
			b1.addActionListener(new ActionListener() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame materia = new JFrame("Matricular Aluno");
					materia.setSize(800, 600);
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
							
							for(Aluno a: diretor.getAlunos())System.out.println(diretor.getAlunos());
						
						}
						
						
					});

					
					//materia.pack();
					materia.show();
	 			}
			});	
		
			
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
			
			b7.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame jf = new JFrame("Atribuicao");
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
											}catch(EscolaException t) {
												JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
											}
										}
									}
								}
							}
								
						}	
					});

					jf.pack();
					jf.show();	
				}
			});
					
					
			b8.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JFrame jf = new JFrame("Atribuicao");
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
											}catch(EscolaException t) {
												JOptionPane.showMessageDialog(null, t, "Erro", JOptionPane.WARNING_MESSAGE);
											}
										}
									}
								}
							}
						}
					});
					
					jf.pack();
					jf.show();	
					}	
				});	

			
			
			b9.addActionListener(new ActionListener() {
				
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
			
			dados.pack();
			dados.show();
	
				}
			});
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
