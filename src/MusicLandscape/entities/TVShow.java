package MusicLandscape.entities;

public class TVShow extends Event {
    private String name;
    private int viewers;

    public TVShow (){}

    public TVShow (Event e){
        super(e);
    }

    public TVShow (TVShow tvs){
        super(tvs);
        setName(tvs.name);
        setViewers(tvs.viewers);
    }

    @Override
    public int impact(){
    return ((viewers + getAttendees()) * 2);
    }

    @Override
    public String toString(){
        return String.format("""
                        %s @ %s on %s
                        %s
                        (%d attending (%d))""",
                getArtist(), getName(), getDate(),
                getDescription(),(getViewers()+ getAttendees()), impact());
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        if( viewers >= 0)
        this.viewers = viewers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!(name == null || name.isBlank()))
        this.name = name;
    }
}
