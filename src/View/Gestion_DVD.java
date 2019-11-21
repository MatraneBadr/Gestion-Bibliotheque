package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import Model.Document;
import Model.DVD;;

public class Gestion_DVD extends JFrame {

	private JPanel contentPane;
	
	private JTextField textFieldCreateur;
	private JTextField textFieldNomOeuvre;
	private JTextField textFieldDureeOeuvre;
	
	JTable table;
	DefaultTableModel model;
	
	DVD dvd1=new DVD();
	private String header []=new String[] {"Nom Createur","Nom DVD","Duree"};
	 ArrayList<DVD>DVD;
	 private JTable table_1;
	 int row,col;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_DVD frame = new Gestion_DVD();
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
	public Gestion_DVD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		textFieldCreateur = new JTextField();
		textFieldCreateur.setBounds(183, 76, 166, 20);
		contentPane.add(textFieldCreateur);
		textFieldCreateur.setColumns(10);
		
		JLabel lblNomDVD = new JLabel("Nom DVD");
		lblNomDVD.setBounds(64, 79, 109, 14);
		contentPane.add(lblNomDVD);
		
		textFieldNomOeuvre = new JTextField();
		textFieldNomOeuvre.setBounds(183, 149, 166, 20);
		contentPane.add(textFieldNomOeuvre);
		textFieldNomOeuvre.setColumns(10);
		
		JLabel lblNomAuteur = new JLabel("Nom Createur");
		lblNomAuteur.setBounds(64, 152, 109, 14);
		contentPane.add(lblNomAuteur);
		
		textFieldDureeOeuvre = new JTextField();
		textFieldDureeOeuvre.setBounds(183, 227, 166, 20);
		contentPane.add(textFieldDureeOeuvre);
		textFieldDureeOeuvre.setColumns(10);
		
		JLabel lblNombreDePages = new JLabel("Duree");
		lblNombreDePages.setBounds(64, 230, 119, 14);
		contentPane.add(lblNombreDePages);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String nb=textFieldDureeOeuvre.getText().toString();
					float nbPage=Float.parseFloat(nb);
					dvd1.adddvd(textFieldCreateur.getText().toString(), textFieldNomOeuvre.getText().toString(), nbPage);
					JOptionPane.showMessageDialog(null, "DVD ajout�");
					viderchamp();
					dvd1.AfficheTab(model);
					
				}catch (Exception e1)
				{e1.printStackTrace();}
			}
		});
		btnAjouter.setBounds(64, 330, 109, 23);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nomDVD=textFieldCreateur.getText();
				String nomAuteur=textFieldNomOeuvre.getText();
				float nbPage=Float.parseFloat(textFieldDureeOeuvre.getText());
				
			
				dvd1.update(row, nomDVD, nomAuteur, nbPage);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "DVD Modifier");
				viderchamp();
				dvd1.AfficheTab(model);
			}
		});
		btnModifier.setBounds(186, 330, 119, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.removeRow(row);
				dvd1.deletedvd(row);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "DVD supprim�e");
				viderchamp();

				dvd1.AfficheTab(model);
			}
		});
		btnSupprimer.setBounds(315, 330, 129, 23);
		contentPane.add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(606, 43, 355, 288);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
		model=new DefaultTableModel(new Object[][] {},header);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				row=table.getSelectedRow();
				String nomDoc = table.getModel().getValueAt(row, 1).toString();
				String auteurDoc = table.getModel().getValueAt(row, 0).toString();
				String dureeDoc = table.getModel().getValueAt(row, 2).toString();
				
				textFieldCreateur.setText(nomDoc);
				textFieldNomOeuvre.setText(auteurDoc);
				textFieldDureeOeuvre.setText(dureeDoc);
			}
		});
		scrollPane.setViewportView(table);
		JButton button1 = new JButton("");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Menu menu=new Menu();
				menu.setVisible(true);
			}
		});
		button1.setIcon(new ImageIcon("C:\\Users\\badr\\Desktop\\Projet\\icons8-windows-10-50.png"));
		button1.setBounds(10, 11, 46, 32);
		contentPane.add(button1);
	}
	public void viderchamp()
	{
		textFieldCreateur.setText("");
		textFieldNomOeuvre.setText("");
		textFieldDureeOeuvre.setText("");
	}
}
