package tabela;

public class Dados {

	private String[] nomes;
	private double[] notas;
	
	public Dados(String[] nomes, double[] notas) throws DadosErradosExcepetion {
		//verifica se há dados suficientes
		if (nomes.length != notas.length)
			throw new DadosErradosExcepetion("A quantidade de nomes e de notas é diferente");
		
		//verifica se a quantidade de dados é o suficiente
		if (nomes.length < 0)
			throw new DadosErradosExcepetion("A quantidade de dados de uma das entradas é insuficente");
		
		//verifica se nenhum nome está em branco
		for (int i = 0; i < notas.length; i++)
			if (nomes[i].equals(""))
				throw new DadosErradosExcepetion("");
		
		//verifica se as notas estão no range entre 0 e 10
		for (int i = 0; i < notas.length; i++)
			if(notas[i]>10 | notas[i]<0)
				throw new DadosErradosExcepetion("Um dos dados referentes a notas esta fora do range");
		
		//Atribui aos atributos
		this.nomes = nomes;
		this.notas = notas;
	}
	
	public String[] getNomes() { return this.nomes; }
	
	public double[] getNotas() { return this.notas; }
}
