package hust.soict.hedpsi.aims.Aims;

import hust.soict.hedpsi.aims.cart.*;
import hust.soict.hedpsi.aims.media.*;
import hust.soict.hedpsi.aims.store.Store;

import java.util.*;

public class Aims {
	private static Cart cart = new Cart();
	private static Store store = new Store();

	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	public static void case1() {
		// whilemenu

		while (true) {
			store.displayStore();
			storeMenu();
			Scanner keyboard = new Scanner(System.in);
			int option = keyboard.nextInt();
			switch (option) {
				case 1:
					System.out.println("Enter the title of the media: ");
					keyboard = new Scanner(System.in);
					String title = keyboard.nextLine();

					Media media = store.searchByTitle(title);
					if (media != null) {
						mediaDetailsMenu();
						int option3 = keyboard.nextInt();
						switch (option3) {
							case 1:
								cart.addMedia(media);
								break;
							case 2:
								// the “Play” option is only available to CD and DVD type.
								// If the media is not a CD or DVD, the system will display a message “The media
								// is not playable”.
								if (media instanceof Playable) {
									((Playable) media).play();
								} else {
									System.out.println("The media is not playable");
								}
								break;
							case 0:
								mainCase();
								break;
						}
					} else {
						System.out.println("The media is not in the store");
					}
					break;
				case 2:
					// o The option “Add a media to cart” will ask the user to enter the title of
					// the media that he/she sees on the screen (the list of medias in store), then
					// add the media to cart. Please remember to check the validity of the title.
					// After adding a DVD to cart, the system will display the number of DVDs in the
					// current cart.
					store.displayStore();
					System.out.println("Enter the title of the media you want to add in cart: ");
					keyboard = new Scanner(System.in);
					title = keyboard.nextLine();
					media = store.searchByTitle(title);
					if (media != null) {
						cart.addMedia(media);
						if (media instanceof DigitalVideoDisc) {
							System.out.println("The number of DVDs in the current cart: " + cart.getQtyOrdered());
						}
					} else {
						System.out.println("The media is not in the store");
					}
					break;
				case 3:
					System.out.println("Enter the title of the media you want to play: ");
					keyboard = new Scanner(System.in);
					title = keyboard.nextLine();
					media = store.searchByTitle(title);
					if (media != null) {
						if (media instanceof Playable) {
							((Playable) media).play();
						} else {
							System.out.println("The media is not playable");
						}
					} else {
						System.out.println("The media is not in the store");
					}
					break;
				case 4:
					cart.display();
					break;
				case 0:
					mainCase();
					break;
			}
		}

	}

	public static void makeDVD() {
		System.out.println("Enter the title of the DVD: ");
		Scanner keyboard = new Scanner(System.in);
		String title = keyboard.nextLine();
		System.out.println("Enter the category of the DVD: ");
		keyboard = new Scanner(System.in);
		String category = keyboard.nextLine();
		System.out.println("Enter the director of the DVD: ");
		keyboard = new Scanner(System.in);
		String director = keyboard.nextLine();
		System.out.println("Enter the length of the DVD: ");
		keyboard = new Scanner(System.in);
		int length = keyboard.nextInt();
		System.out.println("Enter the cost of the DVD: ");
		keyboard = new Scanner(System.in);
		float cost = keyboard.nextFloat();
		DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
		store.add(dvd);
	}

	public static void makeBook() {
		System.out.println("Enter the title of the Book: ");
		Scanner keyboard = new Scanner(System.in);
		String title = keyboard.nextLine();
		System.out.println("Enter the category of the Book: ");
		keyboard = new Scanner(System.in);
		String category = keyboard.nextLine();
		System.out.println("Enter the cost of the Book: ");
		keyboard = new Scanner(System.in);
		float cost = keyboard.nextFloat();
		System.out.println("Enter author of the Book: ");
		keyboard = new Scanner(System.in);
		String author = keyboard.nextLine();
		Book book = new Book(title, category, cost);
		book.setAuthors(author);
		store.add(book);
	}

	public static void makeCD() {
		System.out.println("Enter the title of the CD: ");
		Scanner keyboard = new Scanner(System.in);
		String title = keyboard.nextLine();
		System.out.println("Enter the category of the CD: ");
		keyboard = new Scanner(System.in);
		String category = keyboard.nextLine();
		System.out.println("Enter the cost of the CD: ");
		keyboard = new Scanner(System.in);
		float cost = keyboard.nextFloat();
		System.out.println("Enter the director of the CD: ");
		keyboard = new Scanner(System.in);
		String director = keyboard.nextLine();
		System.out.println("Enter the length of the CD: ");
		keyboard = new Scanner(System.in);
		int length = keyboard.nextInt();
		System.out.println("Enter author of the CD: ");
		keyboard = new Scanner(System.in);
		String author = keyboard.nextLine();
		CompactDisc cd = new CompactDisc(title, category, cost, length, director, author);
		store.add(cd);
	}

	public static void case2() {
		// the application will allow the user to add a media to or remove a media from
		// the store
		while (true) {
			System.out.println("You want do add or remove media from store?");
			System.out.println("1. Add");
			System.out.println("2. Remove");
			System.out.println("0. Back");
			Scanner keyboard = new Scanner(System.in);
			int option = keyboard.nextInt();
			switch (option) {
				case 1:
					System.out.println("Your media is?");
					System.out.println("1. DigitalVideoDisc");
					System.out.println("2. Book");
					System.out.println("3. CompactDisc");
					System.out.println("0. Back");
					keyboard = new Scanner(System.in);
					int option2 = keyboard.nextInt();
					switch (option2) {
						case 1:
							makeDVD();
							break;
						case 2:
							makeBook();
							break;
						case 3:
							makeCD();
							break;
						case 0:
							case2();
							break;
						default:
							System.out.println("invalid option");
					}
					break;
				case 2:
					System.out.println("Enter title of media you want to remove");
					keyboard = new Scanner(System.in);
					String title = keyboard.nextLine();
					Media media = store.searchByTitle(title);
					if (media != null) {
						store.remove(media);
					} else {
						System.out.println("The media is not in the store");
					}
					break;
				case 0:
					mainCase();
					break;

			}
		}

	}

	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	public static void case3() {
		while (true) {
			cart.display();
			cartMenu();
			Scanner keyboard = new Scanner(System.in);
			// get user input
			int option = keyboard.nextInt();
			switch (option) {
				case 1:
					// The “Filter medias in cart” option should allow the user to choose one of two
					// filtering options: by id and by title.
					System.out.println("Filter by id or title?");
					System.out.println("1. Id");
					System.out.println("2. Title");
					keyboard = new Scanner(System.in);
					int option2 = keyboard.nextInt();
					switch (option2) {
						case 1:
							System.out.println("Enter id of media you want to filter");
							keyboard = new Scanner(System.in);
							int id = keyboard.nextInt();
							cart.filterById(id);
							break;
						case 2:
							System.out.println("Enter title of media you want to filter");
							keyboard = new Scanner(System.in);
							String title = keyboard.nextLine();
							cart.filterByTitle(title);
							break;
						default:
							System.out.println("invalid option");
					}
					break;
				case 2:
					// The “Sort medias in cart” option should allow the user to choose one of two
					// sorting option: by title or by cost.
					System.out.println("Sort by title or cost?");
					System.out.println("1. Title");
					System.out.println("2. Cost");
					keyboard = new Scanner(System.in);
					int option3 = keyboard.nextInt();
					switch (option3) {
						case 1:
							cart.sortByTitle();
							break;
						case 2:
							cart.sortByCost();
							break;
						default:
							System.out.println("invalid option");
					}
					break;
				case 3:
					System.out.println("Enter title of media you want to remove");
					keyboard = new Scanner(System.in);
					String title = keyboard.nextLine();
					Media media = cart.searchByTitle(title);
					if (media != null) {
						cart.removeMedia(media);
					} else {
						System.out.println("The media is not in the cart");
					}
					break;
				case 4:
					System.out.println("Enter title of media you want to play");
					keyboard = new Scanner(System.in);
					String title2 = keyboard.nextLine();
					Media media2 = cart.searchByTitle(title2);
					// only DVD and CD can be played
					if (media2 instanceof DigitalVideoDisc || media2 instanceof CompactDisc) {
						media2.play();
					} else {
						System.out.println("The media is not playable");
					}
					break;
				case 5:
					// Note: When the user chooses option “Place order”, the system is supposed to
					// move on to the Delivery Information gathering & Payment step. However, for
					// simplicity, within the scope of this lab course, when the user chooses this
					// option, we only need to notify the user that an order is created and empty
					// the current cart.

					// check if cart is empty
					if (cart.isEmpty()) {
						System.out.println("Cart is empty");
						break;
					} else {
						System.out.println("Order created");
						// empty the cart
						cart = new Cart();
					}

					break;
				case 0:
					mainCase();
					break;
			}

		}

	}

	public static void mainCase() {
		while (true) {
			showMenu();
			// create a new scanner
			Scanner keyboard = new Scanner(System.in);
			// get user input
			int option = keyboard.nextInt();
			switch (option) {
				case 1:
					case1();
					break;
				case 2:
					case2();
					break;
				case 3:
					case3();
					break;
				case 0:
					
					System.out.println("Goodbye");
					return;
			}
		}

	}

	public static void main(String[] args) {
		// display show menu
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 87, "Roger Allers");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 87, "George Lucas");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f, 90, "John Musker");
		store.add((dvd2));
		store.add((dvd1));
		store.add((dvd3));
		mainCase();

	}
}
