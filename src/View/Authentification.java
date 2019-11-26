package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Authentification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentification frame = new Authentification();
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
	public Authentification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(445, 151, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Identifiant");
		lblUsername.setBounds(285, 154, 95, 14);
		contentPane.add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(445, 194, 196, 20);
		contentPane.add(passwordField);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setBounds(285, 197, 113, 14);
		contentPane.add(lblMotDePasse);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		btnAnnuler.setBounds(385, 268, 119, 23);
		contentPane.add(btnAnnuler);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nom="badr";
				String pass="badr1234";
				String pwd = new String(passwordField.getPassword());
				if(textField.getText().equals(nom) && pwd.equals(pass))
					{Menu menu=new Menu();
					menu.setVisible(true);
					}
				else
					JOptionPane.showMessageDialog(null, "Identifiant ou Mot de passe incorrect");
				
			}
		});
		btnConnexion.setBounds(556, 268, 113, 23);
		contentPane.add(btnConnexion);
	}
}
