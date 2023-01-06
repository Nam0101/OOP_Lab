package hust.soict.hedpsi.aims.media;

import java.util.Comparator;



public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	// getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media media = (Media) obj;
			if (this.title.equals(media.title) && this.category.equals(media.category)) {
				return true;
			}
		}
		return false;
	}
	
}
