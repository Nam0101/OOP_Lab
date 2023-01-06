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
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;
	public CartScreen(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		JFrame frame = this;
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart, store, frame);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		Store store = new Store();
		CompactDisc cd = new CompactDisc(1, "cd01", "music", 10.2f, "abcd", "xyz");
		Track t1 = new Track("t1", 10);
		Track t2 = new Track("t2", 8);
		cd.addTrack(t1);
		cd.addTrack(t2);
		DigitalVideoDisc dvd = new DigitalVideoDisc(2, "dvd01", "amime", 20.5f, "hkjh", 20);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc(3, "dvd02", "amime", 20.5f, "naamamam", 20);
		Book book = new Book(4, "book01", "comics", 15.3f);
		store.add(cd);
		store.add(dvd);
		store.add(book);
		store.add(dvd1);
		Cart cart = new Cart();
		new CartScreen(cart, store);
	}
}