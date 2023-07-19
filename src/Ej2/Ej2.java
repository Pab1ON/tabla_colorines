package Ej2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

public class Ej2 extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textN1;
	private JTextField textN2;
	private JTextField textN3;
	private JLabel lblMedia;
	private JLabel lblRes;
	private JTable table;
	private ArrayList<Alumno> listaAlumnos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej2 frame = new Ej2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ej2() {
		listaAlumnos = new ArrayList<Alumno>();
		
		setTitle("CÁLCULO DE PROMEDIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[5.00,grow][47.00,left][53.00][][][][]", "[][30:30.00][30:30.00][][][][20px:11.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, "cell 0 0 7 1,grow");
		
		JLabel lblHeader = new JLabel("CALCULAR PROMEDIO");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeader.setForeground(new Color(255, 255, 255));
		panel.add(lblHeader);
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 1 1,alignx left");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 2 1 5 1,grow");
		textNombre.setColumns(10);
		
		JLabel lblN1 = new JLabel("Nota 1:");
		contentPane.add(lblN1, "cell 1 2,alignx left");
		
		textN1 = new JTextField();
		contentPane.add(textN1, "cell 2 2,alignx left,growy");
		textN1.setColumns(5);
		
		JLabel lblN2 = new JLabel("Nota 2:");
		contentPane.add(lblN2, "cell 3 2,alignx trailing");
		
		textN2 = new JTextField();
		textN2.setColumns(5);
		contentPane.add(textN2, "cell 4 2,alignx left,growy");
		
		JLabel lblN3 = new JLabel("Nota 3:");
		contentPane.add(lblN3, "cell 5 2,alignx trailing");
		
		textN3 = new JTextField();
		textN3.setColumns(5);
		contentPane.add(textN3, "cell 6 2,alignx left,growy");
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumno a = null;
				try {
				a=recoger();
				insertar(a);
				mostrar(a);
				verTabla();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(contentPane, "Debe introducir un número válido", "Error",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnCalc, "cell 5 3 2 1,alignx right");
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblPromedio, "cell 1 4 2 1");
		
		lblMedia = new JLabel("");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblMedia, "cell 3 4 4 1");
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblResultado, "cell 1 5 2 1");
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(lblRes, "cell 3 5 4 1");
		
		getRootPane().setDefaultButton(btnCalc);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 6 7 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Nota 1", "Nota 2", "Nota 3", "Nota media"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, Double.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setDefaultRenderer(Object.class, new MiCellRenderer());
	}
	
	protected void verTabla() {
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		for (Alumno a : listaAlumnos) {
			Object [] fila = {
					a.getNombre(),
					a.getNota1(),
					a.getNota2(),
					a.getNota3(),
					a.getMedia()
			};
			modelo.addRow(fila);
		}
	}

	protected Alumno recoger() {
		Alumno a = null;
		String nombre=textNombre.getText();
		double nota1=Double.parseDouble(textN1.getText());
		double nota2=Double.parseDouble(textN2.getText());
		double nota3=Double.parseDouble(textN3.getText());
		a = new Alumno(nombre,nota1,nota2,nota3);
		return a;
	}

	protected void mostrar(Alumno a) {
		double media=a.getMedia();
		lblMedia.setText(String.format("%.2f", media));
		if (a.isAprobado()) lblRes.setText("Ha aprobado la asignatura");
		else lblRes.setText("Toca recuperar");		
	}

	protected void insertar(Alumno a) {
		listaAlumnos.add(a);		
	}

}
