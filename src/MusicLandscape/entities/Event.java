package MusicLandscape.entities;

import MusicLandscape.Date;
import MusicLandscape.Venue;

public class Event {
    private Artist artist;
    private Venue venue;
    private Date date;
    private String description;
    private int attendees;

    public Event() {
        artist = new Artist();
        venue = null;
        date = null;
        description = "";
        attendees = 0;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        if(artist != null) {
            this.artist = artist;
        }
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Date getDate() {
        if(date != null) {
            return new Date(date);
        } else {
            return null;
        }
    }

    public void setDate(Date date) {
        if(date != null) {
            this.date = new Date(date);
        }
    }

    public int getAttendees() {
        return attendees;
    }

    public void setAttendees(int attendees) {
        if(attendees >= 0) {
            this.attendees = attendees;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description != null) {
            this.description = description;
        }
    }
}
