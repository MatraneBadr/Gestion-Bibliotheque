package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Films_Livres extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Films_Livres frame = new Films_Livres();
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
	public Films_Livres() {
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
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String type=comboBox.getSelectedItem().toString();
				if(type=="Livres")
				{Gestion_Livre livre=new Gestion_Livre();
				livre.setVisible(true);}
				if(type=="Films")
				{Gestion_CD cd=new Gestion_CD();
				cd.setVisible(true);}
			}
		});
		btnValider.setBounds(440, 251, 89, 23);
		contentPane.add(btnValider);
	}
}
