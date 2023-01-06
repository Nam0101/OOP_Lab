package hust.soict.hedpsi.aims.media;

import hust.soict.hedpsi.exception.PlayerException;
import hust.soict.hedpsi.aims.media.Disc;
public class DigitalVideoDisc extends Disc implements Playable {
	
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}

    public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}
	@Override
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength());
			return info;
		} else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
		
	}
}
