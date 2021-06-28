package MusicLandscape.entities;

import MusicLandscape.Venue;
import MusicLandscape.Date;

public class Event {
    private Artist artist = new Artist();
    private Venue venue;
    private Date date;
    private String description = "";
    private int attendees;

    public Event() {
    }

    public Event(final Event e) {
        artist = new Artist(e.artist);
        attendees = e.attendees;
        date = new Date(e.date);
        description = e.description;
        venue = new Venue(e.venue);
    }

    public int impact() {
        return this.getAttendees() * 2;
    }

    public Artist getArtist() {
        return this.artist;
    }

    public void setArtist(final Artist artist) {
        if (artist != null)
            this.artist = artist;
    }

    public Venue getVenue() {
        return this.venue;
    }

    public void setVenue(final Venue venue) {
        this.venue = venue;
    }

    public Date getDate() {
        if (this.date == null)
            return null;
        else
            return new Date(this.date);
    }

    public void setDate(final Date date) {
        if (date == null)
            this.date = null;
        else
            this.date = new Date(date);
    }

    public int getAttendees() {
        return this.attendees;
    }

    public void setAttendees(final int attendees) {
        if (attendees >= 0)
            this.attendees = attendees;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        if (description != null)
            this.description = description;
    }

    @Override
    public String toString() {
        return String.format("""
                        %s @ %s on %s
                        %s
                        (%d attending (%d))""",
                this.getArtist(), (venue == null) ? "unknown" : this.getVenue().getName(), this.getDate(),
                this.getDescription(), this.getAttendees(), this.impact());
    }
}
