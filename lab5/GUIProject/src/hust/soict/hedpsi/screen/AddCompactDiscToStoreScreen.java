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
import java.util.ArrayList;
public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	public AddCompactDiscToStoreScreen(Store store, Cart cart) {
		super(store, cart);
		
		JPanel director = super.createSubPanel("Director");
		JPanel artist = super.createSubPanel("Artist");
		
		super.centerPanel.add(director, BorderLayout.CENTER);
		super.centerPanel.add(artist, BorderLayout.CENTER);
		
		btnAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Compact Disc");
	}
	
	private class btnAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String title=null, category=null, director=null, artist=null;
			float cost=0; int id = 0;
			for (JTextField tf : tfs) {
				if(tf.getName().equals("ID")) {
					id = Integer.parseInt(tf.getText());
				 }else if(tf.getName().equals("Title")) {
					title = tf.getText();
				} else if (tf.getName().equals("Category")) {
					category = tf.getText();
				} else if (tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				} else if (tf.getName().equals("Director")) {
					director = tf.getText();
				} else if (tf.getName().equals("Artist")) {
					artist = tf.getText();
				}
			}
			
			CompactDisc cd =  new CompactDisc(title, category, cost, id, director);
			store.add(cd);
			JOptionPane.showMessageDialog(null, "the "+ cd.getTitle() + " added to store");
		}
	}
}