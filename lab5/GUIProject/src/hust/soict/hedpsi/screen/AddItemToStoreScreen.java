package hust.soict.hedpsi.screen;


import hust.soict.hedpsi.aims.store.Store;
import hust.soict.hedpsi.aims.cart.Cart;
import hust.soict.hedpsi.aims.media.Media;
import hust.soict.hedpsi.aims.media.Book;
import hust.soict.hedpsi.aims.media.DigitalVideoDisc;
import hust.soict.hedpsi.aims.media.CompactDisc;
import hust.soict.hedpsi.aims.media.Track;
import hust.soict.hedpsi.aims.media.Playable;
import hust.soict.hedpsi.screen.StoreScreen;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public abstract class AddItemToStoreScreen extends JFrame {
	Store store;
	Cart cart;
	JPanel centerPanel;
	JButton btnAdd;
	
	ArrayList<JTextField> tfs = new ArrayList<JTextField>();

	public AddItemToStoreScreen(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
		setSize(1024, 768);
		setLayout(new BorderLayout());
		
		add(createMenuBar(), BorderLayout.NORTH);
		
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnAdd = new JButton("Add");
		btnPanel.add(btnAdd);
		btnPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(btnPanel, BorderLayout.SOUTH);
		
		centerPanel = createCenter();
		add(centerPanel, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	JPanel createSubPanel(String text) {
		JPanel subPanel = new JPanel(new FlowLayout());
		JTextField tf = new JTextField(50);
		tf.setName(text);
		tfs.add(tf);
		JLabel lbTextField = new JLabel(text);
		
		subPanel.add(lbTextField);
		subPanel.add(tf);
		subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		return subPanel;
	}
	
	JPanel createCenter() {
		JPanel centerPanel = new JPanel(new GridLayout(7, 1, 4, 4));
		
		JPanel idJPanel = createSubPanel("Id");
		JPanel titlePanel = createSubPanel("Title");
		JPanel categoryPanel = createSubPanel("Category");
		JPanel costPanel = createSubPanel("Cost");
		
		centerPanel.add(idJPanel);
		centerPanel.add(titlePanel);
		centerPanel.add(categoryPanel);
		centerPanel.add(costPanel);
		
		return centerPanel;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenuItem viewStoreMenu = new JMenuItem("View store");
		menu.add(viewStoreMenu);
		viewStoreMenu.addActionListener(new btnMenuListener());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new StoreScreen(store, cart);
			dispose();
		}
	}
}
