package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.Livre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.zip.DataFormatException;

public class Gestion_Livre extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JTable table;
	DefaultTableModel model;
	
	Livre livre=new Livre();
	private String header []=new String[] {"Nom","Nom Livre","nbPages"};

	 ArrayList<Livre>lv;
	 private JTable table_1;
	 int row,col;
	 private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_Livre frame = new Gestion_Livre();
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
	public Gestion_Livre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100,1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 76, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomLivre = new JLabel("Nom Livre");
		lblNomLivre.setBounds(64, 79, 109, 14);
		contentPane.add(lblNomLivre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 149, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomAuteur = new JLabel("Nom Auteur");
		lblNomAuteur.setBounds(64, 152, 109, 14);
		contentPane.add(lblNomAuteur);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 227, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombreDePages = new JLabel("Nombre de pages");
		lblNombreDePages.setBounds(64, 230, 119, 14);
		contentPane.add(lblNombreDePages);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String nb=textField_2.getText().toString();
					int nbPage=Integer.parseInt(nb);
					
					livre.addLivre(textField.getText().toString(), textField_1.getText().toString(), nbPage);
					
					JOptionPane.showMessageDialog(null, "Livre ajouté");
					viderchamp();
					livre.AfficheTab(model);
					
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
				String nomlivre=textField.getText();
				String nomAuteur=textField_1.getText();
				int nbPage=Integer.parseInt(textField_2.getText());
			
				livre.update(row, nomlivre, nomAuteur, nbPage);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Livre Modifier");
				viderchamp();
				livre.AfficheTab(model);
			}
		});
		btnModifier.setBounds(186, 330, 119, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.removeRow(row);
				livre.deleteLivre(row);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Livre supprimée");

				livre.AfficheTab(model);
			}
		});
		btnSupprimer.setBounds(315, 330, 129, 23);
		contentPane.add(btnSupprimer);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(606, 97, 355, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model=new DefaultTableModel(new Object[][] {},header);
		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				row=table.getSelectedRow();
				String nomdoc=table.getModel().getValueAt(row, 1).toString();
				String nomAut=table.getModel().getValueAt(row, 0).toString();
				String nbPage=table.getModel().getValueAt(row, 2).toString();

				textField.setText(nomdoc);
				textField_1.setText(nomAut);
				textField_2.setText(nbPage);
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(606, 53, 154, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=livre.searchLivre(textField_3.getText());
				livre.afficheresultatSearch(i, model);
			}
		});
		btnRechercher.setBounds(823, 52, 119, 23);
		contentPane.add(btnRechercher);
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(606, 43, 355, 288);
		contentPane.add(scrollPane);
		*/
		/*
		JTable table1=new JTable();
		table1.setBounds(606, 43, 355, 288);
		model=new DefaultTableModel(new Object[][] {},header);
		table1.setModel(model);
		this.setLocationRelativeTo(null);
		*/
		
		
		 
		 //table =new  JTable(data,entetes);
		 
	       // scrollPane.setViewportView(list);
		 /*
		table = new JTable();
		table.setRowHeight(34);
	
		dt = new DefaultTableModel(new Object[][] {},
				new String[] { "NomLivre", "NomAuteur", "nbPage" });
		table.setModel(dt);
		
		scrollPane.setViewportView(table);
		
		table.setFillsViewportHeight(true);
		*/
	}
	public void viderchamp()
	{
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
}
