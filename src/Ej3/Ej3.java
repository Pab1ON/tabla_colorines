package Ej3;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej3 extends JFrame {

	private JPanel contentPane;
	private JButton btnHab;
	private JButton btnCentral;
	private JButton btnDes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej3 frame = new Ej3();
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
	public Ej3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 89);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		btnDes = new JButton("Deshabilita Central");
		btnDes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDes.setEnabled(false);
				btnCentral.setEnabled(false);
				btnHab.setEnabled(true);
			}
		});
		contentPane.add(btnDes);
		
		btnCentral = new JButton("Central");
		contentPane.add(btnCentral);
		
		btnHab = new JButton("Habilita Central");
		btnHab.setEnabled(false);
		btnHab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDes.setEnabled(true);
				btnCentral.setEnabled(true);
				btnHab.setEnabled(false);
			}
		});
		contentPane.add(btnHab);
	}

}
