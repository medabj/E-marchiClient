package com.esprit.macchiato.emarchi.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.util.Date;
import java.util.Collection;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JTable;

import com.esprit.macchiato.emarchi.delegate.CategoriesCrudDelegate;
import com.esprit.macchiato.emarchi.delegate.ClientCrudDelegate;
import com.esprit.macchiato.emarchi.delegate.OffersCrudDelegate;
import com.esprit.macchiato.emarchi.domain.Categories;
import com.esprit.macchiato.emarchi.domain.Client;
import com.esprit.macchiato.emarchi.domain.Products;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author MohamedAmine
 *
 */
public class MainMenu extends JFrame {

	private JPanel contentPane;

	// -------------------------------Declarations pour afficher la liste les offres ------------------------------------------------------
	public List<Products> ProdList;
	private JTable Offerstable;
	private List<Categories> CatList;
	JComboBox CatComboBox = new JComboBox();
	//---------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		
		//--------------------
		ProdList=OffersCrudDelegate.findAllOffers();
		CatList=CategoriesCrudDelegate.findAllCategories();
		for(Categories c : CatList){
			CatComboBox.addItem(c.getDescription());
			
		}
		//----------------------------------------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JButton btnNewButton = new JButton("Sign out");
		btnNewButton.setToolTipText("");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Genuine Inscriptions", null, panel_2, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Categories", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Offers", null, panel_1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		//----------------------------------------------------------------------------------------------------------------	
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
	//------------------------------------------------------------------------------------------------------------------------------------
		});
		
		JLabel lblNewLabel = new JLabel("Move To");
		
		JButton btnNewButton_1 = new JButton("Delete Offer");
		btnNewButton_1.addActionListener(new ActionListener() {
			//--------- click pour supprimer la ligne selectionnée--------------------
			public void actionPerformed(ActionEvent e) {
				int offerSelected = Offerstable.getSelectedRow();
				int offerSupp =(int) Offerstable.getModel().getValueAt(offerSelected,0);
				try {
					OffersCrudDelegate.deleteOffer(offerSupp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// pour refraichir la table apres la suppression
				ProdList = OffersCrudDelegate.findAllOffers();
				initDataBindings();
			}
			//---------------------------------------------------------------------
		});
		
		JButton btnNewButton_2 = new JButton("Delete Offer and Delete Client");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int clientSelected = Offerstable.getSelectedRow();
				int clientSupp = (int) Offerstable.getModel().getValueAt(clientSelected, 6);
				try {
					ClientCrudDelegate.delete(clientSupp);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ProdList = OffersCrudDelegate.findAllOffers();
				initDataBindings();
			}
		});
		
		JButton btnOk = new JButton("OK");
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(32)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(CatComboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnOk)
							.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_2))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(CatComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOk)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		Offerstable = new JTable();
		scrollPane.setViewportView(Offerstable);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}
	protected void initDataBindings() {
		
		
		//------------------------------------------------------------------------------------------------------------------------------------------------------------
		// Jtable des offres  
		
		JTableBinding<Products, List<Products>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ProdList, Offerstable);

		//
		BeanProperty<Products, Integer> photoBeanProperty = BeanProperty.create("IDProduct");
		jTableBinding.addColumnBinding(photoBeanProperty).setColumnName("ID Offer");
		//
		BeanProperty<Products, String> photoBeanProperty_1 = BeanProperty.create("nameProduct");
		jTableBinding.addColumnBinding(photoBeanProperty_1).setColumnName("Product Name");
		//
		BeanProperty<Products, String> photoBeanProperty_2 = BeanProperty.create("Description");
		jTableBinding.addColumnBinding(photoBeanProperty_2).setColumnName("Offer Description");
		//
		BeanProperty<Products, String> photoBeanProperty_3 = BeanProperty.create("categorie.Description");
		jTableBinding.addColumnBinding(photoBeanProperty_3).setColumnName("Category");
		//
		BeanProperty<Products, Float> photoBeanProperty_4 = BeanProperty.create("Price");
		jTableBinding.addColumnBinding(photoBeanProperty_4).setColumnName("Price");
		//
		BeanProperty<Products, Date> photoBeanProperty_5 = BeanProperty.create("depotDate");
		jTableBinding.addColumnBinding(photoBeanProperty_5).setColumnName("Add Date");
		//
		BeanProperty<Products, Client> photoBeanProperty_6 = BeanProperty.create("owner.IDClient");
		jTableBinding.addColumnBinding(photoBeanProperty_6).setColumnName("Owner");
		//
		
		jTableBinding.bind();
		//--------------------------------------------------------------------------------------------------------------------------------------------------------------
		
	}
	
	
}
