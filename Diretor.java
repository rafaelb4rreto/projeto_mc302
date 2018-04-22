
public class Diretor extends Pessoa{
	
	private int salario;
	
	public Diretor(String nome,int idade,char sexo,String dataNascimento,String RA,String senha,int salario) {
		super(nome,idade,sexo,dataNascimento,RA,senha);
		this.salario = salario;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}
	
	public void setBonus(Professor prof,int bonus) {
		prof.setSalario((bonus + prof.getSalario()));
	}
	
	
	

	@Override
	public String toString() {
		String out = super.toString();
		out = out +"\nDiretor [salario=" + salario + "]";
		return out;
	}
	
	

}
