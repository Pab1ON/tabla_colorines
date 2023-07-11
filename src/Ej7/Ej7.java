package Ej7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej7 extends JFrame {

	private JPanel contentPane;
	private JTextField textPelis;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej7 frame = new Ej7();
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
	public Ej7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 230);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][16.00][13.00][127.00][][140.00]", "[][27.00][][30.00][]"));
		
		JLabel lblT1 = new JLabel("Título:");
		contentPane.add(lblT1, "cell 1 1 3 1");
		
		JLabel lblT2 = new JLabel("Películas:");
		contentPane.add(lblT2, "cell 5 1,alignx center");
		
		textPelis = new JTextField();
		contentPane.add(textPelis, "cell 2 2 2 1,growx");
		textPelis.setColumns(10);
		
		comboBox = new JComboBox<>();
		contentPane.add(comboBox, "cell 5 2,growx");
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				comboBox.addItem(textPelis.getText());
				introducePeli();
				textPelis.setText("");
			}
		});
		contentPane.add(btnAdd, "cell 3 4");
		getRootPane().setDefaultButton(btnAdd);
	}

	protected void introducePeli() {
		String peli=textPelis.getText();
		boolean esta=true;
		for (int i=0;i<comboBox.getItemCount() && esta;i++) if (peli.equalsIgnoreCase(comboBox.getItemAt(i))) esta=false;
		if (peli!=null && !peli.isBlank() && esta) comboBox.addItem(peli.trim());
	}

}
