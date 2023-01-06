package hust.soict.hedpsi.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedpsi.aims.media.DigitalVideoDisc;
import hust.soict.hedpsi.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(media);
			System.out.println("The media has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The media has been removed");
		} else {
			System.out.println("The media is not in the cart");
		}
	}

	public int getQtyOrdered() {
		return itemsOrdered.size();
	}

	public void display() {
		System.out.println("***********************Cart***********************");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println("       " + itemsOrdered.get(i).getTitle());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}

	public void filterById(int id) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getId() == id) {
				System.out.println("The media is in the cart");
				return;
			}
		}
		System.out.println("The media is not in the cart");
	}

	public void filterByTitle(String title) {
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equals(title)) {
				System.out.println("The media is in the cart");
				return;
			}
		}
		System.out.println("The media is not in the cart");
	}

	public void sortByTitle() {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = i + 1; j < itemsOrdered.size(); j++) {
				if (itemsOrdered.get(i).getTitle().compareTo(itemsOrdered.get(j).getTitle()) > 0) {
					Media temp = itemsOrdered.get(i);
					itemsOrdered.set(i, itemsOrdered.get(j));
					itemsOrdered.set(j, temp);
				}
			}
		}
	}

	public void sortByCost() {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = i + 1; j < itemsOrdered.size(); j++) {
				if (itemsOrdered.get(i).getCost() > itemsOrdered.get(j).getCost()) {
					Media temp = itemsOrdered.get(i);
					itemsOrdered.set(i, itemsOrdered.get(j));
					itemsOrdered.set(j, temp);
				}
			}
		}
	}

	public Media searchByTitle(String title) {
		// upper and lower case
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
				return itemsOrdered.get(i);
			}
		}
		return null;
	}

    public boolean isEmpty() {
		if (itemsOrdered.size() == 0) {
			return true;
		}
        return false;
    }

    
}
