public class Main {
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Maria",57,'F',"20/07/1960","1a2b3c");
		Pessoa p2 = new Pessoa("Joao",44,'M',"03/05/1974","abcd");
		Pessoa p3 = new Pessoa("Jose",12,'M',"02/06/2005","1234");
		
		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","1a2b3c",20000);
		//System.out.println(d.toString());
		
		Professor prof = new Professor("Joao",44,'M',"03/05/1974","abcd","134B",10000);
		Professor prof2 = new Professor("Joaquim",44,'M',"03/05/1974","abcd","134B",10000);
		//System.out.println(prof.toString());
		Professor.setNumMaxTutorados(4);
		
		Aluno a1 = new Aluno("Jose",12,'M',"02/06/2005","1234",5,false,0,"matutino");
		Aluno a2 = new Aluno("Clarinha",2,'F',"02/06/2015","1234",5,false,0,"matutino");
	//	System.out.println(a1.toString());
		
		prof.adicionarTutorado(a1);
		
		Materia m1 = new Materia("Geografia","G 001",4,"66A","10h", Dia.SEGUNDA);
		//System.out.println(m1.toString());
		
		Materia m2 = new Materia("Matematica","MA002",5,"66B","08h",Dia.QUINTA);
		
		Materia m3 = new Materia("Calculo Avancado","MA666", 4, "22A", "14h", Dia.SEXTA);
		
		prof.adicionarMateria(m3);
		prof2.adicionarMateria(m3);
		
		a1.adicionarMateria(m1);
		a1.adicionarMateria(m2);
		a2.adicionarMateria(m3);
		a1.adicionarMateria(m3);
		a1.removerMateria(m3);
		System.out.println("\n"+a1);

		System.out.println("\n"+a2);
		
		System.out.println("\n"+m3);
		
		
		//		System.out.println("\n"+prof);
		
		prof.removerTutorado(a1);
//		System.out.println("\n"+prof.toString());
		
		d.setBonus(prof, 1000);
//		System.out.println("\n"+prof.toString());
		
	}

}
