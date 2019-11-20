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
import Model.CD;

public class Gestion_CD extends JFrame {

	private JPanel contentPane;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JTable table;
	DefaultTableModel model;
	
	CD cd1=new CD();
	private String header []=new String[] {"Nom Createur","Nom CD","Duree"};
	 ArrayList<CD>cd;
	 private JTable table_1;
	 int row,col;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion_CD frame = new Gestion_CD();
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
	public Gestion_CD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(183, 76, 166, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNomcd = new JLabel("Nom CD");
		lblNomcd.setBounds(64, 79, 109, 14);
		contentPane.add(lblNomcd);
		
		textField_1 = new JTextField();
		textField_1.setBounds(183, 149, 166, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomAuteur = new JLabel("Nom Createur");
		lblNomAuteur.setBounds(64, 152, 109, 14);
		contentPane.add(lblNomAuteur);
		
		textField_2 = new JTextField();
		textField_2.setBounds(183, 227, 166, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNombreDePages = new JLabel("Duree");
		lblNombreDePages.setBounds(64, 230, 119, 14);
		contentPane.add(lblNombreDePages);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					String nb=textField_2.getText().toString();
					float nbPage=Float.parseFloat(nb);
					cd1.addcd(textField.getText().toString(), textField_1.getText().toString(), nbPage);
					JOptionPane.showMessageDialog(null, "CD ajouté");
					viderchamp();
					cd1.AfficheTab(model);
					
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
				String nomcd=textField.getText();
				String nomAuteur=textField_1.getText();
				float nbPage=Float.parseFloat(textField_2.getText());
				
			
				cd1.update(row, nomcd, nomAuteur, nbPage);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "cd Modifier");
				viderchamp();
				cd1.AfficheTab(model);
			}
		});
		btnModifier.setBounds(186, 330, 119, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.removeRow(row);
				cd1.deletecd(row);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "cd supprimée");

				cd1.AfficheTab(model);
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
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
}
