package MusicLandscape.entities;

public class Artist {
    private String name;

    public Artist() {
        setName("unknown");
    }

    public Artist(Artist a) {
        this.name = a.name;
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!(name == null || name.isEmpty() || name.isBlank())) {
            this.name = name;
        }
    }
}
