package Ej10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej10 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej10 frame = new Ej10();
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
	public Ej10() {
		setTitle("Panel de Scroll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][][grow][][][]"));
		
		JLabel lblNewLabel = new JLabel("Aceptar las condiciones del servicio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		contentPane.add(lblNewLabel, "cell 0 0");
		
		JLabel lblNewLabel_1 = new JLabel("Acuerdo de licencia");
		contentPane.add(lblNewLabel_1, "cell 0 1");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 2,grow");
		
		JTextPane txtpnmuyImportantelee = new JTextPane();
		txtpnmuyImportantelee.setEditable(false);
		txtpnmuyImportantelee.setText("¡¡¡MUY IMPORTANTE!!!\r\n¡¡¡LEE DETENIDAMENTE!!!\r\n¡¡¡SI NO LO LEES ESTARÁS COMETIENDO UN GRAVE ERROR!!!\r\n\r\nBaja hasta abajo del todo para leer todo el acuerdo de usuario.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nAceptas ser buena persona. :)");
		scrollPane.setViewportView(txtpnmuyImportantelee);
		txtpnmuyImportantelee.setCaretPosition(0);
		
		JRadioButton rdbtnSi = new JRadioButton("Aceptar Condiciones del Servcio");
		buttonGroup.add(rdbtnSi);
		contentPane.add(rdbtnSi, "cell 0 3");
		
		JRadioButton rdbtnNo = new JRadioButton("No aceptar");
		rdbtnNo.setSelected(true);
		buttonGroup.add(rdbtnNo);
		contentPane.add(rdbtnNo, "cell 0 4");
		
		JButton btnNext = new JButton("Siguiente");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mensaje(rdbtnSi);
			}
		});
		contentPane.add(btnNext, "cell 0 5,alignx center");
	}

	protected void mensaje(JRadioButton rdbtnSi) {
		if (!rdbtnSi.isSelected()) {
			int opcion=JOptionPane.showConfirmDialog(null, "¿Estás seguro?","Confirmación", JOptionPane.YES_NO_OPTION);
			if (opcion==JOptionPane.OK_OPTION) JOptionPane.showMessageDialog(null, "La próxima vez será","Rechazado",JOptionPane.PLAIN_MESSAGE);
			else if (opcion!=JOptionPane.CLOSED_OPTION) JOptionPane.showMessageDialog(null, "Pasa por caja...","Confirmado",JOptionPane.PLAIN_MESSAGE);
		} else JOptionPane.showMessageDialog(null, "Pasa por caja...","Confirmado",JOptionPane.PLAIN_MESSAGE);
		
	}

	public boolean sino(JRadioButton rdbtnSi) {
		if (rdbtnSi.isSelected()) return true;
		return false;		
	}

}
