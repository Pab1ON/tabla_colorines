package Ej4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej4 extends JFrame {

	private JPanel contentPane;
	private JCheckBox chckbxH1;
	private JCheckBox chckbxH2;
	private JCheckBox chckbxH3;
	private JCheckBox chckbxH4;
	private JTextPane textRes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej4 frame = new Ej4();
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
	public Ej4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][25.00][][][][][][grow]", "[][][15.00][][][][][][grow]"));
		
		JLabel lblHobbies = new JLabel("Hobbits:");
		contentPane.add(lblHobbies, "cell 1 1");
		
		JLabel lblSelec = new JLabel("Has seleccionado:");
		contentPane.add(lblSelec, "cell 5 1");
		
		chckbxH1 = new JCheckBox("Frodo");
		chckbxH1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRes.setText(comprobar(chckbxH1,chckbxH2,chckbxH3,chckbxH4));	
			}
		});
		contentPane.add(chckbxH1, "cell 2 2");
		
		textRes = new JTextPane();
		contentPane.add(textRes, "cell 4 2 6 4,grow");
		
		chckbxH2 = new JCheckBox("Sam");
		chckbxH2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRes.setText(comprobar(chckbxH1,chckbxH2,chckbxH3,chckbxH4));	
			}
		});
		contentPane.add(chckbxH2, "cell 2 3");
		
		chckbxH3 = new JCheckBox("Merry");
		chckbxH3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRes.setText(comprobar(chckbxH1,chckbxH2,chckbxH3,chckbxH4));	
			}
		});
		contentPane.add(chckbxH3, "cell 2 4");
		
		chckbxH4 = new JCheckBox("Pippin");
		chckbxH4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRes.setText(comprobar(chckbxH1,chckbxH2,chckbxH3,chckbxH4));	
			}
		});
		contentPane.add(chckbxH4, "cell 2 5");
		
		JButton btnCheck = new JButton("Comprobar");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textRes.setText(comprobar(chckbxH1,chckbxH2,chckbxH3,chckbxH4));	
			}

			
		});
		contentPane.add(btnCheck, "cell 4 7 2 1");
	}
	private String comprobar(JCheckBox c1,JCheckBox c2,JCheckBox c3,JCheckBox c4) {
		String hobbits="";
		if (c1.isSelected()) hobbits=hobbits+c1.getText()+"\n";
		if (c2.isSelected()) hobbits=hobbits+c2.getText()+"\n";
		if (c3.isSelected()) hobbits=hobbits+c3.getText()+"\n";
		if (c4.isSelected()) hobbits=hobbits+c4.getText()+"\n";
		return hobbits;
	}

}
