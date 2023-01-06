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

public class MediaStore extends JPanel {
	private Media media;
	private Cart cart;
	public MediaStore(Media media, Cart cart) {
		this.media = media;
		this.cart = cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+"$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
		addToCartButton.addActionListener(new AddToCartbtnListener());
		container.add(addToCartButton);
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(new PlaybtnListener());
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	private class PlaybtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int w = 175;
			try {
				JOptionPane.showMessageDialog(null, String.format(((Playable)media).play().toString(), w, w));
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}
	private class AddToCartbtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			cart.addMedia(media);
			JOptionPane.showMessageDialog(null, "the "+ media.getTitle() + " added to cart");
		}	
	}
}