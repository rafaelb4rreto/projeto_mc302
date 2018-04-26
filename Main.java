/*
 *  Este programa consiste num sistema que auxilia na administração de uma escola.
 *  Nele os professores e diretores poderão consultar e alterar diversos dados,
 *  desde dados de um aluno específico até dados de matérias e professores.
 *  Os alunos também poderão consultar os dados pessoais para controlar o seu desempenho escolar.
 *  
 *  O programa esta em desenvolvimento. Nesta versao estao implementadas algumas
 *  funcoes basicas e testes dessas funcoes; ainda serao implementadas novas funcoes.
 *  
 *  Para melhor entendimento do codigo, a classe Professor foi comentada em detalhes,
 *  por isso recomendamos que ela seja a primeira a ser analisada.
 */

// A funcao Main faz os testes das funcionalidades ja implementadas
public class Main {
	
	public static void main(String[] args) {
		
		// alocacao e inicalizacao de objetos para testarmos todas as implementacoes do programa.
		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","0001","1a2b3c",20000);
		Professor prof = new Professor("Joao",44,'M',"03/05/1974","abcd","134B",10000);
		Aluno a1 = new Aluno("Jose",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");
		Aluno a3 = new Aluno("Paulo",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");
		Materia m1 = new Materia("Geografia","1",4,"66A","10h",Dia.SEGUNDA,30);
		Materia m2 = new Materia("Matematica","2",5,"66B","08h",Dia.SEGUNDA,20);
		Materia m3 = new Materia("Ciencias","3",3,"66C","10h",Dia.SEGUNDA,20);
		
		d.setMaxCred(a1, 4); 		 // seta como 4 o maximo de creditos que o aluno a1 pode cursar
		a1.adicionarMateria(m1);	 // tenta adicionar as materias m1 e m2 ao aluno a1
		a1.adicionarMateria(m2);
		System.out.println("\n" + a1 + "\n"); // o resultado mostrara que o limitador de creditos esta funcionando
		
		d.setMaxCred(a1, 20);
		a3.adicionarMateria(m1);
		a3.adicionarMateria(m3);
		System.out.println("\n" + a3); // o resultado mostra que o sistema consegue impedir que um mesmo 
									   // aluno tente adicionar mais de uma materia no mesmo horario
		System.out.println("\n" + m1+ "\n"); // mostra se o aluno de fato foi cadastrado na materia

		
		a3.adicionarNotas(m1, 9.5f);   // adiciona a nota 9,5 ao aluno a3 referente a materia m1
		System.out.println("\n" + a3+ "\n"); // teste de adicao de notas

		prof.adicionarMateria(m1);	 // associa a materia m1 ao professor prof (ele lecionara a materia m1)
		prof.setNumMaxTutorados(4);  // seta como 4 o numero maximo de tutorados do professor prof
		System.out.println("\n" + prof);    // teste de limite de tutorados
		System.out.println("\n" + m1+ "\n"); // teste de adicao de materias e de profs responsaveis pela materia

		
		
		a3.removerMateria(m1);
		System.out.println("\n" + a3); // remocao de materias 
		System.out.println("\n" + m1); // teste de remocao de alunos cadastrados
		
		
		d.setBonus(prof, 1000);		   // seta um bonus salarial ao professor prof de 1000 reais
		System.out.println("\n" + prof); // teste de atribuicao de bonus

	}

}