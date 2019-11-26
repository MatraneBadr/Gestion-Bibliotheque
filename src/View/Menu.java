package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import Projet.Authentification;
//import Projet.MenuEtudiant;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Films_Livres doc=new Films_Livres();
				doc.setVisible(true);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\badr\\Desktop\\Projet\\doc\\64x64.png"));
		button.setBounds(300, 174, 119, 100);
		contentPane.add(button);
		
		JLabel lblLivres = new JLabel("Gestion Documents");
		lblLivres.setBounds(300, 298, 138, 14);
		contentPane.add(lblLivres);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\badr\\Desktop\\Projet\\loan.png"));
		button_1.setBounds(590, 174, 119, 100);
		contentPane.add(button_1);
		
		JLabel lblEm = new JLabel("Emprunt");
		lblEm.setBounds(629, 298, 138, 14);
		contentPane.add(lblEm);
		JButton button_2 = new JButton("");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Authentification aut = new Authentification();
				aut.setVisible(true);
				Menu.this.setVisible(false);
				//etatcon();
			   
			
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\badr\\Desktop\\Projet\\logout (1).png"));
		button_2.setBounds(903, 11, 57, 38);
		contentPane.add(button_2);
	}
}
