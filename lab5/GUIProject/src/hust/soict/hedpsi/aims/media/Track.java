package hust.soict.hedpsi.aims.media;

public class Track implements Playable {
    String title;
    int length;
    // getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    // Create constructor(s)
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }
    @Override
    public StringBuffer play() {
        StringBuffer info = new StringBuffer("");
        info.append("Playing Track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
        return info;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            if (this.title.equals(track.title) && this.length == track.length) {
                return true;
            }
        }
        return false;
    }
	
    
}
