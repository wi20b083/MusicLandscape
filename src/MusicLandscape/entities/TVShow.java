package MusicLandscape.entities;

public class TVShow extends Event {
    private String name;
    private int viewers;

    public TVShow (){}

    public TVShow (final Event e){
        super(e);
    }

    public TVShow (final TVShow tvs){
        super(tvs);
        this.setName(tvs.name);
        this.setViewers(tvs.viewers);
    }

    @Override
    public int impact(){
    return ((this.viewers + this.getAttendees()) * 2);
    }

    @Override
    public String toString(){
        return String.format("""
                        %s @ %s on %s
                        %s
                        (%d attending (%d))""",
                this.getArtist(), this.getName(), this.getDate(),
                this.getDescription(),(this.getViewers()+ this.getAttendees()), this.impact());
    }

    public int getViewers() {
        return this.viewers;
    }

    public void setViewers(final int viewers) {
        if( viewers >= 0)
        this.viewers = viewers;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        if(!(name == null || name.isBlank()))
        this.name = name;
    }
}
