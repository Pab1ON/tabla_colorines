package Ej1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ej1 extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField textPass;
	private static final String user="Usuario";
	private static final String pass="Contraseña";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ej1 frame = new Ej1();
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
	public Ej1() {
		setTitle("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 337, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow]", "[9.00][22.00][4.00][][][]"));
		
		JLabel lblUser = new JLabel("Usuario:");
		contentPane.add(lblUser, "cell 1 1,alignx right");
		
		textUser = new JTextField();
		contentPane.add(textUser, "cell 3 1,growx");
		textUser.setColumns(10);
		
		JLabel lblPass = new JLabel("Contraseña:");
		contentPane.add(lblPass, "cell 1 3");
		
		textPass = new JPasswordField();
		contentPane.add(textPass, "cell 3 3,growx");
		textPass.setColumns(10);
		
		JButton btnSubmit = new JButton("Aceptar");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar();
			}
		});
		contentPane.add(btnSubmit, "cell 3 5,alignx right");
	}
	public void comprobar() {
		String cUser=textUser.getText();
		String cPass=new String (textPass.getPassword());
		if (!cUser.equals(user) || !cPass.equals(pass))
			JOptionPane.showMessageDialog(null, "Login incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Bienvenido");
	}
	
}
