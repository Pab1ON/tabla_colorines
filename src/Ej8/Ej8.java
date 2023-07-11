package Ej8;

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

@SuppressWarnings("serial")
public class Ej8 extends JFrame {

	private JPanel contentPane;
	private JTextField textNum;
	private final ButtonGroup buttonGroupF = new ButtonGroup();
	private final ButtonGroup buttonGroupT = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej8 frame = new Ej8();
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
	public Ej8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][63.00][grow]", "[][13.00][][][][][]"));
		
		JLabel lblTitle = new JLabel("Conversión de monedas");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblTitle, "cell 0 0 4 1");
		
		JLabel lblNewLabel_1 = new JLabel("De:");
		contentPane.add(lblNewLabel_1, "cell 0 2,alignx right");
		
		JRadioButton rdbtnFD = new JRadioButton("Dólares");
		rdbtnFD.setActionCommand("0");
		rdbtnFD.setSelected(true);
		buttonGroupF.add(rdbtnFD);
		contentPane.add(rdbtnFD, "cell 1 2");
		
		JRadioButton rdbtnFE = new JRadioButton("Euros");
		buttonGroupF.add(rdbtnFE);
		contentPane.add(rdbtnFE, "cell 2 2");
		
		JRadioButton rdbtnFY = new JRadioButton("Yenes");
		buttonGroupF.add(rdbtnFY);
		contentPane.add(rdbtnFY, "cell 3 2");
		
		JLabel lblNewLabel = new JLabel("Cantidad:");
		contentPane.add(lblNewLabel, "cell 0 3,alignx trailing");
		
		textNum = new JTextField();
		contentPane.add(textNum, "cell 1 3 3 1,growx");
		textNum.setColumns(10);
			
		
		JLabel lblNewLabel_2 = new JLabel("A:");
		contentPane.add(lblNewLabel_2, "cell 0 5,alignx right");
		
		JRadioButton rdbtnTD = new JRadioButton("Dólares");
		buttonGroupT.add(rdbtnTD);
		contentPane.add(rdbtnTD, "cell 1 5");
		
		JRadioButton rdbtnTE = new JRadioButton("Euros");
		rdbtnTE.setSelected(true);
		buttonGroupT.add(rdbtnTE);
		contentPane.add(rdbtnTE, "cell 2 5");
		
		JRadioButton rdbtnTY = new JRadioButton("Yenes");
		buttonGroupT.add(rdbtnTY);
		contentPane.add(rdbtnTY, "cell 3 5");
		
		JLabel lblNewLabel_3 = new JLabel("Resultado:");
		contentPane.add(lblNewLabel_3, "cell 1 6,alignx left");
		
		JLabel lblRes = new JLabel("€");
		contentPane.add(lblRes, "cell 2 6");
		
		JButton btnCalc = new JButton("Calcular");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num=convertir(rdbtnFE,rdbtnFY,rdbtnTE,rdbtnTY);
				char s=symbol(rdbtnTD,rdbtnTE,rdbtnTY);
				lblRes.setText(String.format("%f%c", num,s));
			}
		});
		contentPane.add(btnCalc, "cell 1 4 3 1,alignx center");
	}
	protected char symbol(JRadioButton rdbtnTD, JRadioButton rdbtnTE, JRadioButton rdbtnTY) {
		char s=' ';
		if (rdbtnTD.isSelected()) s='$';
		if (rdbtnTE.isSelected()) s='€';
		if (rdbtnTY.isSelected()) s='¥';
		return s;		
	}

	private double convertir(JRadioButton rdbtnFE, JRadioButton rdbtnFY,JRadioButton rdbtnTE, JRadioButton rdbtnTY) {
		double num=Double.parseDouble(textNum.getText());
		if (rdbtnFE.isSelected() && !rdbtnTE.isSelected()) num=num*1.1;
		if (rdbtnFY.isSelected() && !rdbtnTY.isSelected()) num=num*0.0070;
		if (rdbtnTE.isSelected() && !rdbtnFE.isSelected()) num=num*0.91;
		if (rdbtnTY.isSelected() && !rdbtnFY.isSelected()) num=num*142.36;
		return num;
	}
}
