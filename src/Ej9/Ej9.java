package Ej9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ej9 extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	private final ButtonGroup buttonGroupF = new ButtonGroup();
	private final ButtonGroup buttonGroupT = new ButtonGroup();
	private final static double conversiones[][] = {{1,0.91,142.48},{1.09,1,142.42},{0.007,0.0064,1}};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej9 frame = new Ej9();
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
	public Ej9() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][84.00][][63.00][grow]", "[][13.00][][][][][]"));
		
		JLabel lblTitle = new JLabel("Conversión de monedas");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblTitle, "cell 0 0 4 1");
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		JComboBox<String> comboFrom = new JComboBox<String>();
		comboFrom.setModel(new DefaultComboBoxModel<String>(new String[] {"Dólares", "Euros", "Yenes"}));
		contentPane.add(comboFrom, "cell 1 2 3 1,growx");
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		contentPane.add(lblNewLabel, "cell 0 3,alignx trailing");
		
		textNum = new JTextField();
		contentPane.add(textNum, "cell 1 3 3 1,growx");
		textNum.setColumns(10);
			
		
		JLabel lblNewLabel_2 = new JLabel("A:");
		contentPane.add(lblNewLabel_2, "cell 0 5,alignx trailing");
		
		JComboBox<String> comboTo = new JComboBox<String>();
		comboTo.setModel(new DefaultComboBoxModel<String>(new String[] {"Dólares", "Euros", "Yenes"}));
		contentPane.add(comboTo, "cell 1 5 3 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Resultado:");
		contentPane.add(lblNewLabel_3, "cell 1 6,alignx left");
		
		JLabel lblRes = new JLabel("€");
		contentPane.add(lblRes, "cell 2 6");
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num=convertir(comboFrom,comboTo);
				char s=symbol(comboTo);
				lblRes.setText(String.format("%f%c", num,s));
			}
		});
		contentPane.add(btnCalc, "cell 1 4 3 1,alignx center");
	}
	protected char symbol(JComboBox comboTo) {
		char s=' ';
		if (comboTo.getSelectedIndex()==0) s='$';
		if (comboTo.getSelectedIndex()==1) s='€';
		if (comboTo.getSelectedIndex()==2) s='¥';
		return s;		
	}

	private double convertir(JComboBox comboFrom,JComboBox comboTo) {
		int from=comboFrom.getSelectedIndex();
		int to=comboTo.getSelectedIndex();
		double num=Double.parseDouble(textNum.getText());
		num=num*conversiones[from][to];
		return num;
	}
}