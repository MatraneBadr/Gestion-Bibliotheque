package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Emprunt_livres_Films extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprunt_livres_Films frame = new Emprunt_livres_Films();
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
	public Emprunt_livres_Films() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(380, 209, 200, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Selectionner");
		comboBox.addItem("Livres");
		comboBox.addItem("Films");
		comboBox.addItem("Musiques");
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(440, 251, 89, 23);
		contentPane.add(btnValider);
	}

}
