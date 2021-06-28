package MusicLandscape.entities;

public class Track {
    private String title;
    private int duration;
    private Artist writer = new Artist();
    private Artist performer = new Artist();
    private int year;

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
        return title != null ? title : "unknown title";
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
                getTitle().equals("unknown title") ? "unknown" : getTitle(),
                writerIsKnown() ? getWriter().getName() : "unknown",
                getPerformer() != null && getPerformer().getName() != null ? getPerformer().getName() : "unknown",
                getDuration() / 60,
                getDuration() % 60);
    }
}
