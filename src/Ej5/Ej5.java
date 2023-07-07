package Ej5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Ej5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej5 frame = new Ej5();
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
	public Ej5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][]"));
		
		JLabel lblTitle = new JLabel("Selecciona un color");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblTitle, "cell 0 0 5 1");
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(Color.BLUE);
		contentPane.add(panel, "cell 4 1 1 4,grow");
		ButtonGroup bg=new ButtonGroup();
		
		JRadioButton rdbtnA = new JRadioButton("Azul");
		rdbtnA.setSelected(true);
		bg.add(rdbtnA);
		rdbtnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.blue);
			}
		});
		rdbtnA.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbtnA, "cell 1 1");
			
		JRadioButton rdbtnR = new JRadioButton("Rojo");
		bg.add(rdbtnR);
		rdbtnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.red);
			}
		});
		rdbtnR.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbtnR, "cell 1 2");
		
		JRadioButton rdbtnV = new JRadioButton("Verde");
		bg.add(rdbtnV);
		rdbtnV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.green);
			}
		});
		rdbtnV.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbtnV, "cell 1 3");
		
		JRadioButton rdbtnM = new JRadioButton("Magenta");
		bg.add(rdbtnM);
		rdbtnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.magenta);
			}
		});
		rdbtnM.setHorizontalAlignment(SwingConstants.TRAILING);
		contentPane.add(rdbtnM, "cell 1 4");
		
		
	}

}
