public enum Dia {
	SEGUNDA(1, "Segunda"), TERCA(2, "Terça"), QUARTA(3,"Quarta"),
	QUINTA(4, "Quinta"), SEXTA(5, "Sexta"), SABADO(6, "Sábado"), DOMINGO(7, "Domingo");
	
	int valor;
	String nome_string;
	
	Dia(int valor, String nome_string) {
		this.valor = valor;
		this.nome_string = nome_string;
	}
}