package tabela;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

//Software vai criar uma tabela de notas com valores fixos e imutáveis
public class TabelaDeNotas extends JFrame implements TableModel{
	
	private String[] colunas = {"Nome:", "Nota:"};
	private String[] nomes = {"Maria", "José", "Laura", "Matheus", "Francisco"};
	private double[] notas = { 5.0, 3.0, 10.0, 9.5, 7.5 };

	private TabelaDeNotas() {
		//configurações básicas
		super("Tabela de Notas");																	//chama construtor da superclasse
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										//encerra o formulário ao clicar em fechar
		this.setResizable(true);																	//define como redimensionável
		this.setSize(400, 400);																		//define tamanho
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();								//centraliza o formulário na tela
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);	
		ImageIcon icon = new ImageIcon(getClass().getResource("icons8-grade-2-24.png"));			//cria e define o ícone
		this.setIconImage(icon.getImage());	
		this.setLayout(new BorderLayout()); 														//define o layout
		this.add(new JScrollPane(new JTable(this)), BorderLayout.CENTER);							//cria uma Jtable dentro de um JScrollPane
																									//e adiciona ao formulário no centro
		this.setVisible(true);																		//exibe o formulário
	}
	
	public static void main(String[] args) {
		new TabelaDeNotas();
	}

	//métodos sobrescritos do interface TableModel
	@Override
	public void addTableModelListener(TableModelListener l) {}										//não implementado pois a tabela é fixa
	@Override
	public Class<?> getColumnClass(int columnIndex) { return Object.class; }						//Todas as colunas não terão formatação especifica
	@Override
	public int getColumnCount() { return colunas.length; }											//Quantidade de colunas é determinada pelo array string colunas
	@Override
	public String getColumnName(int columnIndex) { return colunas[columnIndex]; }					//O header das colunas está contido no array string colunas
	@Override
	public int getRowCount() { return nomes.length; }												//A quantidade de linhas é determinada pelo array nome, o array notas é equivalente
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {										//Retorna o valor associado pelo indice de cada array
		if (columnIndex == 0) {																		//como só há duas colunas a lógica de retorno é simples
			return this.nomes[rowIndex];															//se a coluna for zero, a linha retornada refere-se ao nome
		}else {																						//caso não, retorna a linha referente à nota
			return this.notas[rowIndex];
		}
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }					//nenhuma linha é editável
	@Override
	public void removeTableModelListener(TableModelListener l) {}									//não implementado pois a tabela é fixa
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}							//não implementado pois os valores da tabela são fixos

}
