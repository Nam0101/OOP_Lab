package hust.soict.hedpsi.aims.media;

import java.util.ArrayList;

import hust.soict.hedpsi.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
	public CompactDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
		//TODO Auto-generated constructor stub
	}



    private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	// constructor
	

	public void addTrack(Track track) {
		// check if track is already in the list
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				System.out.println("Track is already in the list");
				return;
			}
		}
		tracks.add(track);
	}

	public void removeTrack(Track track) {
		// check if track is in the list
		for (int i = 0; i < tracks.size(); i++) {
			if (tracks.get(i).getTitle().equals(track.getTitle())) {
				tracks.remove(i);
				return;
			}
		}
		System.out.println("Track is not in the list");
	}

	public int getLength() {
		int length = 0;
		for (int i = 0; i < tracks.size(); i++) {
			length += tracks.get(i).getLength();
		}
		return length;
	}

	@Override
	public StringBuffer play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			
			StringBuffer info = new StringBuffer("");
			info.append("Playing CD: " + this.getTitle() + "\n" + "CD length: " + this.getLength() + "\n");
			
			for (Track t : tracks) {
				try {
					StringBuffer trackInfo = this.play();
					info.append(trackInfo + "\n");
				} catch (PlayerException e) {
					throw e;
				}
			}
			return info;
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		
		
	}
	// - What class should implement the Comparable interface?
	// - What is the type of the object that you want to compare?
	// - What is the method signature of the compareTo() method?
	// - What is the logic of the compareTo() method?
	// - What is the return value of the compareTo() method?
	// - What is the meaning of the return value of the compareTo() method?

}
