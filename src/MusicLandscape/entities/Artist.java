package MusicLandscape.entities;

public class Artist {
    private String name;

    public Artist(final Artist a){
        if(a == null) return;
        name = a.name;
    }

    public Artist(){
    }

    public Artist(final String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        if (!(name == null || name.trim().equals("")))
        this.name = name;
    }

    @Override
    public String toString(){
        if(this.name ==null || this.name.trim().equals(""))
            return "unknown";
        return this.name;
    }
}