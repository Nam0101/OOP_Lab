

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private DigitalVideoDisc itemsOdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
			System.out.println("The cart is almost full");
		} else {
			itemsOdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOdered[i].equals(disc)) {
				if (i == qtyOrdered - 1) {
					qtyOrdered--;
				} else {
					for (int j = i + 1; j < qtyOrdered; j++) {
						itemsOdered[j] = itemsOdered[j - 1];
					}
					qtyOrdered--;
				}
				System.out.println("The disc has been removed");
			}
		}

	}

	public float totalCost() {
		float sumCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			sumCost += itemsOdered[i].getCost();
		}
		return sumCost;
	}

	public DigitalVideoDisc findByCost(float minCost, float maxCost) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOdered[i].getCost() > minCost && itemsOdered[i].getCost() < maxCost) {
				return itemsOdered[i];
			}
		}
		return null;
	}
	public DigitalVideoDisc findByTitle(String titleFind){
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOdered[i].getTitle().equals(titleFind)) {
				return itemsOdered[i];
			}
		}
		return null;
	}

	public void display() {
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println("Title:" + itemsOdered[i].getTitle());
			System.out.println("Category:" + itemsOdered[i].getCategory());
			System.out.println("Director:" + itemsOdered[i].getDirector());
			System.out.println("Length:" + itemsOdered[i].getLength());
			System.out.println("Cost:" + itemsOdered[i].getCost());
			System.out.println("------------------------------------------------");
		}
	}

}
