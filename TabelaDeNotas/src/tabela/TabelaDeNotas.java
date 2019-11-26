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

//Software vai criar uma tabela de notas com valores fixos e imut�veis
public class TabelaDeNotas extends JFrame implements TableModel{
	
	private String[] colunas = {"Nome:", "Nota:"};
	private String[] nomes = {"Maria", "Jos�", "Laura", "Matheus", "Francisco"};
	private double[] notas = { 5.0, 3.0, 10.0, 9.5, 7.5 };

	private TabelaDeNotas() {
		//configura��es b�sicas
		super("Tabela de Notas");																	//chama construtor da superclasse
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);										//encerra o formul�rio ao clicar em fechar
		this.setResizable(true);																	//define como redimension�vel
		this.setSize(400, 400);																		//define tamanho
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();								//centraliza o formul�rio na tela
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);	
		ImageIcon icon = new ImageIcon(getClass().getResource("icons8-grade-2-24.png"));			//cria e define o �cone
		this.setIconImage(icon.getImage());	
		this.setLayout(new BorderLayout()); 														//define o layout
		this.add(new JScrollPane(new JTable(this)), BorderLayout.CENTER);							//cria uma Jtable dentro de um JScrollPane
																									//e adiciona ao formul�rio no centro
		this.setVisible(true);																		//exibe o formul�rio
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TabelaDeNotas();
	}

	@Override
	public void addTableModelListener(TableModelListener l) {}

	@Override
	public Class<?> getColumnClass(int columnIndex) { return Object.class; }

	@Override
	public int getColumnCount() { return colunas.length; }

	@Override
	public String getColumnName(int columnIndex) { return colunas[columnIndex]; }

	@Override
	public int getRowCount() { return nomes.length; }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return this.nomes[rowIndex];
		}else {
			return this.notas[rowIndex];
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

	@Override
	public void removeTableModelListener(TableModelListener l) {}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}

}
