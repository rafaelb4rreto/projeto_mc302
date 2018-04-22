import java.util.ArrayList;


public class Main {
	
	public static void main(String[] args) {
		Pessoa p1 = new Pessoa("Maria",57,'F',"20/07/1960","0001","1a2b3c");
		Pessoa p2 = new Pessoa("Joao",44,'M',"03/05/1974","1001","abcd");
		Pessoa p3 = new Pessoa("Jose",12,'M',"02/06/2005","2001","1234");
		
		Diretor d = new Diretor("Maria",57,'F',"20/07/1960","0001","1a2b3c",20000);
		//System.out.println(d.toString());
		
		Professor prof = new Professor("Joao",44,'M',"03/05/1974","1001","abcd","134B",10000);
		//System.out.println(prof.toString());
		prof.setNumMaxTutorados(4);
		
		Aluno a1 = new Aluno("Jose",12,'M',"02/06/2005","2001","1234",5,false,0,"matutino");
		System.out.println(a1.toString());
		
		prof.adicionarTutorado(a1);
		
		Materia m1 = new Materia("Geografia",1,4,"66A","10h");
		//System.out.println(m1.toString());
		
		Materia m2 = new Materia("Matematica",2,5,"66B","08h");
		
		a1.adicionarMateria(m1);
		a1.adicionarMateria(m2);
		System.out.println("\n"+a1.toString());
		System.out.println("\n"+prof.toString());
		
		prof.removerTutorado(a1);
		System.out.println("\n"+prof.toString());
		
		d.setBonus(prof, 1000);
		System.out.println("\n"+prof.toString());
		



	}

}
