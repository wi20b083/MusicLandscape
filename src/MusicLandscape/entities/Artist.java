package MusicLandscape.entities;

public class Artist implements Comparable<Artist> {
    private String name;

    public Artist(Artist a){
        if(a == null) return;
        this.name = a.name;
    }

    public Artist(){
    }

    public Artist(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (!(name == null || name.trim().equals("")))
        this.name = name;
    }

    @Override
    public String toString(){
        if(this.name ==null || this.name.trim().equals(""))
            return "unknown";
        return this.name;
    }

    @Override
    public int compareTo(Artist o) {
        return this.name.compareTo(o.name);
    }
}