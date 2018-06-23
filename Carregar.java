import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Carregar {

	//Carrega arquivo escola.txt dentro da pasta src do projeto
		public static void carregarDados() {
			
			String filename = "src/escola.txt";
			try {
				Scanner scan = new Scanner(new File(filename));
				Diretor dir = new Diretor(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.nextInt());
				dir.setCaixa(scan.nextInt());
				dir.setRA(scan.nextInt());
				int temp = scan.nextInt(); //numero de alunos
				for(int i=0; i<temp;i++) { //matricular e ajustar cada aluno
					dir.matricularAluno(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.nextInt());
					dir.getAlunos().get(i).setRA(scan.nextInt());
					dir.getAlunos().get(i).setAdvertencias(scan.nextInt());
					dir.getAlunos().get(i).setSuspensoes(scan.nextInt());
					dir.getAlunos().get(i).setMaxCreditos(scan.nextInt());
					dir.getAlunos().get(i).setRegular(scan.nextBoolean());
					dir.getAlunos().get(i).setBalanco(scan.nextInt());
					dir.getAlunos().get(i).setMensalidade(scan.nextInt());
				}
				temp = scan.nextInt(); //numero de professores
				for(int i=0; i<temp;i++) {
					dir.contratarProfessor(scan.next(), scan.nextInt(), scan.next().charAt(0), scan.next(), scan.next(), scan.next(), scan.nextInt());
					dir.getProfessores().get(i).setRA(scan.nextInt());
					dir.getProfessores().get(i).setPago(scan.nextBoolean());
				}
				temp = scan.nextInt();	//numero de materias
				for(int i=0; i<temp;i++) {
					dir.abrirMateria(scan.next(), scan.next(), scan.nextInt(), scan.next(), scan.next(), Dia.valueOf(scan.next()), scan.nextInt(), scan.nextLine());
					int tempRA = scan.nextInt();
					for(int j=0;j<dir.getProfessores().size();j++) {
							
						if(dir.getProfessores().get(j).getRA() == tempRA) {
							dir.atribuirMateriaAUmProfessor(dir.getProfessores().get(j), dir.getMaterias().get(i));
						}
					}
					int qtdDeAlunos = scan.nextInt();
					for(int k=0;k<qtdDeAlunos;k++) { //para cada aluno, recriar o relacionamento
						int alunoRA = scan.nextInt();
						float notaAluno = scan.nextFloat();
						for(int l=0;l<dir.getAlunos().size();l++) {  //busca do aluno
							
							if(dir.getAlunos().get(l).getRA() == alunoRA) {
								dir.getAlunos().get(l).adicionarMateria(dir.getMaterias().get(i)); //recriando o relacionamento AlunoMateria
								dir.getAlunos().get(l).getMaterias().get(dir.getAlunos().get(l).getMaterias().size() - 1).setNota(notaAluno); // recoloca a nota dessa materia
							}
						}
					}
					
				}
						
				scan.close();
						
				System.out.println(dir.getMaterias().get(0).getEmenta());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (EscolaException e) {
				System.err.println(e);
			}
			
		}
	
	
}
