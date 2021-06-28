package MusicLandscape.entities;

public class Track {
    private String title;
    private int duration;
    private Artist writer;
    private Artist performer;
    private int year;

    public Track() {
        setTitle(null);
        setDuration(0);
        setWriter(new Artist());
        setPerformer(new Artist());
        setYear(1900);
    }

    public Track(Track t) {
        this.title = t.title;
        this.duration = t.duration;
        this.writer = new Artist(t.writer);
        this.performer = new Artist(t.performer);
        this.year = t.year;
    }

    public Track(String title) {
        this();
        setTitle(title);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year >= 1900 && year <= 2999) {
            this.year = year;
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if(duration >= 0) {
            this.duration = duration;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(Artist writer) {
        if(writer != null) {
            this.writer = writer;
        }
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if(performer != null) {
            this.performer = performer;
        }
    }

    public boolean writerIsKnown() {
        return writer != null && writer.getName() != null;
    }

    public String getString() {
        return String.format("%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
                getTitle(),
                getWriter().getName(),
                getPerformer().getName(),
                getDuration() / 60,
                getDuration() % 60);
    }
}
