package Ej6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Ej6 extends JFrame {

	private JPanel contentPane;
	private JLabel lblSelected;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej6 frame = new Ej6();
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
	public Ej6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 345, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow]", "[][][51.00][][][grow]"));
		
		JLabel lblCity = new JLabel("Ciudad:");
		contentPane.add(lblCity, "cell 1 1,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Adamuz", "Cabra", "Córdoba", "Lucena", "Moltanbán", "Montilla", "Monturque"}));
		contentPane.add(comboBox, "cell 2 1,growx");
		
		JLabel lblSelect = new JLabel("Has seleccionado:");
		contentPane.add(lblSelect, "cell 1 3");
		
		lblSelected = new JLabel("");
		contentPane.add(lblSelected, "cell 2 3");
		
		JButton btnAcept = new JButton("Aceptar");
		btnAcept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ciudad=(String) comboBox.getSelectedItem();
				sacaCiudad(ciudad);
			}
		});
		contentPane.add(btnAcept, "cell 2 5,aligny top");
	}
	
	public void sacaCiudad(String ciudad) {
		lblSelected.setText(ciudad);
	}

}
