

public class Main {
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Maria",57,'F',"20/07/1960","1a2b3c");
		Pessoa p2 = new Pessoa("Joao",44,'M',"03/05/1974","abcd");
		Pessoa p3 = new Pessoa("Jose",12,'M',"02/06/2005","1234");
		
		Aluno a3 = new Aluno("Paulo",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");

		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","0001","1a2b3c",20000);
		//System.out.println(d.toString());
		
		Professor prof = new Professor("Joao",44,'M',"03/05/1974","abcd","134B",10000);
		//System.out.println(prof.toString());
		prof.setNumMaxTutorados(4);
		Materia m1 = new Materia("Geografia","1",4,"66A","10h",Dia.SEGUNDA,30);
		Materia m2 = new Materia("Matematica","2",5,"66B","08h",Dia.SEGUNDA,20);
		Materia m3 = new Materia("Ciencias","3",3,"66C","10h",Dia.SEGUNDA,20);
		Aluno a1 = new Aluno("Jose",12,'M',"02/06/2005","1234",5,false,0,0,"matutino");
		
		d.setMaxCred(a1, 4); 
		a1.adicionarMateria(m1);
		a1.adicionarMateria(m2);
		System.out.println("\n"+a1); //teste de adição de materias levando em conta numero de creditos
		
		d.setMaxCred(a1, 20);
		a3.adicionarMateria(m1);
		a3.adicionarMateria(m3);
		System.out.println("\n"+a3); //teste de adição de materias levando em conta horario
		
		a3.adicionarNotas(m1, 9.5f);
		System.out.println("\n"+a3); //teste de adição de notas

		
		a3.removerMateria(m1);
		System.out.println("\n"+a3); //remoção de materias 
		
		
		
		
		
		

		
		
		
		
		prof.adicionarTutorado(a1);
		
		
		//System.out.println(m1.toString());		
		
		
		
		prof.adicionarMateria(m1);
		//System.out.println("\n"+m1.toString());

		//System.out.println("\n"+a1.toString());

		//System.out.println("\n"+m1.toString());
		
		
		prof.removerTutorado(a1);
		
		
		d.setBonus(prof, 1000);
		
		//System.out.println("\n"+prof.toString());
		



	}

}
