public class Main {
	
	public static void main(String[] args) {
		
		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","0001","1a2b3c",20000);
		Professor prof = new Professor("Joao",44,'M',"03/05/1974","abcd","134B",10000);
		Aluno a1 = new Aluno("Jose",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");
		Aluno a3 = new Aluno("Paulo",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");
		Materia m1 = new Materia("Geografia","1",4,"66A","10h",Dia.SEGUNDA,30);
		Materia m2 = new Materia("Matematica","2",5,"66B","08h",Dia.SEGUNDA,20);
		Materia m3 = new Materia("Ciencias","3",3,"66C","10h",Dia.SEGUNDA,20);
		
		d.setMaxCred(a1, 4); 
		a1.adicionarMateria(m1);
		a1.adicionarMateria(m2);
		System.out.println("\n"+a1); //teste de adição de materias levando em conta numero de creditos
		
		d.setMaxCred(a1, 20);
		a3.adicionarMateria(m1);
		a3.adicionarMateria(m3);
		System.out.println("\n"+a3); //teste de adição de materias levando em conta horario
		System.out.println("\n"+m1); //teste de adição alunos cadastrados

		
		a3.adicionarNotas(m1, 9.5f);
		System.out.println("\n"+a3); //teste de adição de notas

		prof.adicionarMateria(m1);
		prof.setNumMaxTutorados(4);
		System.out.println(prof); // teste de limite de tutorados
		System.out.println("\n"+m1); //teste de adicao de materias e de profs responsaveis pela materia

		
		
		a3.removerMateria(m1);
		System.out.println("\n"+a3); //remoção de materias 
		System.out.println("\n"+m1); //teste de remoçao de alunos cadastrados
		
		
		d.setBonus(prof, 1000);
		System.out.println("\n"+prof); //teste de atribuicao de bonus
		



	}

}