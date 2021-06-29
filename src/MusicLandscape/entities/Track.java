package MusicLandscape.entities;

import java.util.Objects;

public class Track {
    private String title;
    private int duration;
    private int year = 1900;
    private Artist writer = new Artist();
    private Artist performer = new Artist();

    public  Track(){
    }

    public Track(String title){
        setTitle(title);
    }

  public Track(Track t){
      this.title =  t.title;
      this.year = t.year;
      this.duration = t.duration;
      this.performer = new Artist(t.performer);
      this.writer = new Artist(t.writer);
    }

    public String getTitle() {
        return Objects.requireNonNullElse(title, "unknown title");
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if ( duration >= 0)
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if( year > 1899 && year < 3000)
        this.year = year;
    }

    public Artist getWriter() {
        return this.writer;
    }

    public void setWriter(Artist writer) {
        if(writer != null)
        this.writer = writer;
    }

    public Artist getPerformer() {
        return performer;
    }

    public void setPerformer(Artist performer) {
        if(performer != null)
        this.performer = performer;
    }

    public boolean writerIsKnown() {
        return !(this.writer == null || this.writer.getName() == null);
    }

    public String getString() {
        return String.format(
                "%10.10s by %10.10s performed by %10.10s (%02d:%02d)",
                (this.title == null) ? "unknown" : getTitle(),
                (this.writer == null || this.writer.getName() == null) ? "unknown" : getWriter().getName(),
                (this.performer == null || this.performer.getName() == null) ? "unknown" : getPerformer().getName(),
                getDuration() / 60,
                getDuration() % 60);
    }

    @Override
    public String toString(){
        return getString();
    }
}