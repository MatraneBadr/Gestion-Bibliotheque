package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Model.Emprunt;
import Model.Livre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Eumprunt_livre extends JFrame {

	private JPanel contentPane;
	JTable table;
	private String header []=new String[] {"Livre","Date debut d'emprunt","Date fin d'emprunt"};
	Emprunt emprunt=new Emprunt();
	DefaultTableModel model;
	JComboBox comboBox;
	int row;
	Livre livre1=new Livre();
	//JDatechosser datechoseer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eumprunt_livre frame = new Eumprunt_livre();
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
	public Eumprunt_livre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivres = new JLabel("Livres");
		lblLivres.setBounds(109, 98, 119, 14);
		contentPane.add(lblLivres);
		
		 comboBox = new JComboBox();
		comboBox.setBounds(249, 94, 164, 22);
		contentPane.add(comboBox);
		comboBox.addItem("selectionner");
		remplistelivre();
		remplircombobox();

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(249, 152, 164, 20);
		contentPane.add(dateChooser);
		
		JLabel lblDateDebutDemprunt = new JLabel("Date debut d'emprunt");
		lblDateDebutDemprunt.setBounds(109, 158, 130, 14);
		contentPane.add(lblDateDebutDemprunt);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(249, 211, 164, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblDateDfinDemprunt = new JLabel("Date fin d'emprunt");
		lblDateDfinDemprunt.setBounds(109, 217, 130, 14);
		contentPane.add(lblDateDfinDemprunt);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				String date=sdf.format(dateChooser.getDate());
				String date1=sdf1.format(dateChooser_1.getDate());
				//System.out.println(date1);
				String Film=comboBox.getSelectedItem().toString();
				String[] splited = Film.split("\\s+");
				String createurDocument=splited[1];
				String nomDocument=splited[0];
				Livre livre=new Livre(nomDocument, createurDocument);
				emprunt.addEmprunt(nomDocument,createurDocument, date, date1);
				JOptionPane.showMessageDialog(null, "Livre ajouté");
				Object obj=comboBox.getSelectedItem();
				comboBox.removeItem(obj);
				viderchamp();
				emprunt.AfficheTab(model);
			
				
			}
		});
		btnAjouter.setBounds(64, 330, 109, 23);
		contentPane.add(btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Film=comboBox.getSelectedItem().toString();
				String[] splited = Film.split("\\s+");
				String createurDocument=splited[1];
				String nomDocument=splited[0];
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				String date=sdf.format(dateChooser.getDate());
				String date1=sdf1.format(dateChooser_1.getDate());
				emprunt.update(row, nomDocument, createurDocument, date,date1);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Livre Modifier");
				viderchamp();
				emprunt.AfficheTab(model);
			}
		});
		btnModifier.setBounds(186, 330, 119, 23);
		contentPane.add(btnModifier);
		

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				model.removeRow(row);
				emprunt.deleteEmprunt(row);
				model.setRowCount(0);
				JOptionPane.showMessageDialog(null, "Livre supprimée");

				emprunt.AfficheTab(model);
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
				
				String Livre=table.getModel().getValueAt(row, 0).toString();
				//String datefin=table.getModel().getValueAt(row, 2).toString();

				comboBox.setSelectedItem(Livre);
				Date date = null ,date1 = null;
				try {
					date = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row, 1));
					 
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					date1 = new SimpleDateFormat("yyyy-MM-dd").parse((String)table.getValueAt(row, 2));
					 
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dateChooser.setDate(date);
				dateChooser_1.setDate(date1);
			}
		});
		scrollPane.setViewportView(table);
	}
	public void viderchamp()
	{
		comboBox.setSelectedItem("selectionner");}
	public void remplistelivre()
	{
		for(int i=0;i<10;i++)
		{
			livre1.addLivre("doc"+i, "CreateurDoc"+i, 100);
			
		}
		
		 
	}
	
	public void remplircombobox()
	{ 
		
		ArrayList<Livre> listlivre=new ArrayList<Livre>();
		listlivre=livre1.getliste();
		for(int i=0;i<listlivre.size();i++)
		{
			String nom=listlivre.get(i).getNomDocument();
			String createurdoc=listlivre.get(i).getCreateurDocument();
			comboBox.addItem(nom+" "+createurdoc);
			
		}}

}
