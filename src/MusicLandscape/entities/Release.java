package MusicLandscape.entities;

public abstract class Release {
    private Artist artist = new Artist();
    private int year = 1900;
    private String title;

    public Release(){
    }

    public Release(Release orig) {
        this.artist = new Artist(orig.artist);
        this.year = orig.year;
        this.title = orig.title;
    }

    public Release(String title, Artist artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public String getTitle(){
        return title != null ? title : "unknown";
    }

    public void setTitle(String title){
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(!(year < 0)) {
            this.year = year;
        }
    }

    public abstract int totalTime();

    public String toString(){
        return String.format("%s-%s-%s-%d",
                getTitle(),
                getArtist().toString(),
                getYear() == 0 ? "unknown" : getYear(),
                totalTime());
    }
}
