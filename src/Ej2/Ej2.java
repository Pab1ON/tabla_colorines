package Ej2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej2 extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textN1;
	private JTextField textN2;
	private JTextField textN3;
	private JLabel lblMedia;
	private JLabel lblRes;

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
		setTitle("CÁLCULO DE PROMEDIO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[5.00,grow][47.00,left][53.00][][][][][grow]", "[][][30:30.00][30:30.00][grow][][][11.00,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, "cell 0 0 8 1,grow");
		
		JLabel lblHeader = new JLabel("CALCULAR PROMEDIO");
		lblHeader.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeader.setForeground(new Color(255, 255, 255));
		panel.add(lblHeader);
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 1 2,alignx left");
		
		textNombre = new JTextField();
		contentPane.add(textNombre, "cell 2 2 5 1,grow");
		textNombre.setColumns(10);
		
		JLabel lblN1 = new JLabel("Nota 1:");
		contentPane.add(lblN1, "cell 1 3,alignx left");
		
		textN1 = new JTextField();
		contentPane.add(textN1, "cell 2 3,alignx left,growy");
		textN1.setColumns(5);
		
		JLabel lblN2 = new JLabel("Nota 2:");
		contentPane.add(lblN2, "cell 3 3,alignx trailing");
		
		textN2 = new JTextField();
		textN2.setColumns(5);
		contentPane.add(textN2, "cell 4 3,alignx left,growy");
		
		JLabel lblN3 = new JLabel("Nota 3:");
		contentPane.add(lblN3, "cell 5 3,alignx trailing");
		
		textN3 = new JTextField();
		textN3.setColumns(5);
		contentPane.add(textN3, "cell 6 3,alignx left,growy");
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double media=media();
				lblMedia.setText(String.format("%.2f", media));
				if (pasa(media)) lblRes.setText("Ha aprobado la asignatura");
				else lblRes.setText("Toca recuperar");
			}
		});
		btnCalc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnCalc, "cell 5 4 2 1,alignx right");
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPromedio, "cell 1 5 2 1");
		
		lblMedia = new JLabel("");
		lblMedia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblMedia, "cell 3 5 5 1");
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblResultado, "cell 1 6 2 1");
		
		lblRes = new JLabel("");
		lblRes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblRes, "cell 3 6 5 1");
		
		getRootPane().setDefaultButton(btnCalc);
	}
	
	public double media() {
		double promedio=((Double.parseDouble(textN1.getText()))+(Double.parseDouble(textN2.getText()))+(Double.parseDouble(textN3.getText())))/3;
		return promedio;
	}
	public boolean pasa(double media) {
		if (media<5) return false;
		return true;
	}

}
