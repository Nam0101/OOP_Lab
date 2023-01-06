package hust.soict.hedpsi.screen;
import hust.soict.hedpsi.aims.store.Store;
import hust.soict.hedpsi.aims.cart.Cart;
import hust.soict.hedpsi.aims.media.Media;
import hust.soict.hedpsi.aims.media.Book;
import hust.soict.hedpsi.aims.media.DigitalVideoDisc;
import hust.soict.hedpsi.aims.media.CompactDisc;
import hust.soict.hedpsi.aims.media.Track;
import hust.soict.hedpsi.aims.media.Playable;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class AddBookToStoreScreen extends AddItemToStoreScreen {
	public AddBookToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Book");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null;
			float cost=0; int id = 0;
			for (JTextField tf : tfs) {
				if(tf.getName().equals("ID")) {
					id = Integer.parseInt(tf.getText());
				}
				if (tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if (tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
			}
			
			Book b =  new Book(id, title, category, cost);
			store.add(b);
			JOptionPane.showMessageDialog(null, "the "+ b.getTitle() + " added to store");
		}
	}
}