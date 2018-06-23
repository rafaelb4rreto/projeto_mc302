import java.util.ArrayList;
import javax.swing.*;


// A funcao Main faz os testes das funcionalidades ja implementadas
public class Main {
	
	public static void main(String[] args) {
		
		//alocacao e inicalizacao de objetos para testarmos todas as implementacoes do programa.
		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","1a2b3c",20000);
		
		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		professores.add(d.contratarProfessor("Joao",44,'M',"03/05/1974","abcd","134B",10000));
		professores.add(d.contratarProfessor("Joao",44,'M',"03/05/1974","abcd","134B",10000));
		alunos.add(d.matricularAluno("Jose",12,'M',"02/06/2005","1234",5));
		alunos.add(d.matricularAluno("Fernando",12,'M',"02/06/2005","1234",5));
		alunos.add(d.matricularAluno("Paulo",12,'M',"02/06/2005","1234",5));
		Materia m1 = d.abrirMateria("Geografia","1",4,"66A","10h",Dia.SEGUNDA,30,"Materia de Geografia");
		Materia m2 = d.abrirMateria("Matematica","2",5,"66B","08h",Dia.SEGUNDA,20,"Materia de Matematica");
		//Materia m3 = d.abrirMateria("Ciencias","3",3,"66C","10h",Dia.SEGUNDA,20,"Materia de Ciencias");
		
		
		
		try { //atribui materia aos professores
			d.atribuirMateriaAUmProfessor(professores.get(0), m1);
			d.atribuirMateriaAUmProfessor(professores.get(1), m2);
		} catch(EscolaException e) {
			System.err.println(e);
		}
		
		JFrame janela = new Login(d);
		d.setMaxCreditos(alunos.get(0),10); 		 // seta como 4 o maximo de creditos que o aluno a1 pode cursar
		
		try {
			alunos.get(0).adicionarMateria(m1);
		} catch (EscolaException e) {
			System.err.println(e);
		}	 // tenta adicionar as materias m1 e m2 ao aluno a1
		
		
		try {
			alunos.get(0).adicionarMateria(m2);
		} catch (EscolaException e) {
			System.err.println(e);
		}
		
		
		System.out.println("\n" + alunos.get(0) + "\n"); // o resultado mostrara que o limitador de creditos esta funcionando
		
		
		
		d.setMaxCreditos(alunos.get(0), 20);
		d.setMaxCreditos(alunos.get(1), 20);
		d.setMaxCreditos(alunos.get(2), 20);

		
		try {
			alunos.get(2).adicionarMateria(m1);
			alunos.get(1).adicionarMateria(m1);
			alunos.get(1).adicionarMateria(m2);

		} catch (EscolaException e1) {
			System.err.println(e1);
		}
		
		System.out.println("\n" + alunos.get(2)); // o resultado mostra que o sistema consegue impedir que um mesmo 
									   // aluno tente adicionar mais de uma materia no mesmo horario
		System.out.println("\n" + m1+ "\n"); // mostra se o aluno de fato foi cadastrado na materia
		System.out.println("num de alunos cadastrados "+m1.getAlunosCadastrados().size());

		try {
			professores.get(0).adicionarNotas(alunos.get(0),m1, 9.5f);   // adiciona a nota 9,5 ao aluno a3 referente a materia m1
			professores.get(0).adicionarNotas(alunos.get(2), m1, 7.5f);
			professores.get(0).adicionarNotas(alunos.get(1), m1, 7.5f);

		} catch (EscolaException e) {
			System.err.println(e);
		}
		

		
		System.out.println("\n" + professores.get(0));    
		System.out.println("\n" + m1+ "\n"); // teste de adicao de materias e de profs responsaveis pela materia

		
		//alunos.get(2).removerMateria(m1);
		System.out.println("\n" + alunos.get(2)); // remocao de materias 
		System.out.println("\n" + m1); // teste de remocao de alunos cadastrados
		
		
		d.setBonus(professores.get(1), 1000);		   // seta um bonus salarial ao professor prof de 1000 reais
		System.out.println("\n" + professores.get(1)); // teste de atribuicao de bonus

		try {
			professores.get(1).editarEmenta("Ementa alterada",m2);
		} catch (EscolaException e) {
			
			System.err.println(e);
		}
		

		for(int i = 0;i < m1.getAlunosCadastrados().size();i++) { //checando se a atribuição de notas esta correta
			System.out.println(m1.getAlunosCadastrados().get(i).getNota());
		}
		
		try {
			System.out.println(professores.get(0).mediaMateria(m1)); //media dos alunos na materia m1 lecionada pelo prof1
		} catch (EscolaException e) {
			System.err.println(e);
		}
		
		try {	//manda mensagem
			professores.get(0).enviarMensagem("OI!",alunos.get(1));
		}catch(EscolaException e) {
			System.err.println(e);
		}
		
		try {	//manda mensagem
			professores.get(0).removerMateria(m2);
		}catch(EscolaException e) {
			System.err.println(e);
		}
		
	}
}
