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

    public Track(final String title){
        this.setTitle(title);
    }

  public Track(final Track t){
      title =  t.title;
      year = t.year;
      duration = t.duration;
      performer = new Artist(t.performer);
      writer = new Artist(t.writer);
    }

    public String getTitle() {
        return Objects.requireNonNullElse(this.title, "unknown title");
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(final int duration) {
        if ( duration >= 0)
        this.duration = duration;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(final int year) {
        if( year > 1899 && year < 3000)
        this.year = year;
    }

    public Artist getWriter() {
        return writer;
    }

    public void setWriter(final Artist writer) {
        if(writer != null)
        this.writer = writer;
    }

    public Artist getPerformer() {
        return this.performer;
    }

    public void setPerformer(final Artist performer) {
        if(performer != null)
        this.performer = performer;
    }

    public boolean writerIsKnown() {
        return !(writer == null || writer.getName() == null);
    }

    public String getString() {
        return String.format(
                "%10s by %10s performed by %10s (%02d:%02d)",
                (title == null) ? "unknown" : this.getTitle().substring(0,Math.min(10, this.getTitle().length())),
                (writer == null || writer.getName() == null) ? "unknown" : this.getWriter().getName().substring(0,Math.min(10, this.getWriter().getName().length())),
                (performer == null || performer.getName() == null) ? "unknown" : this.getPerformer().getName().substring(0,Math.min(10, this.getPerformer().getName().length())),
                this.getDuration() / 60,
                this.getDuration() % 60);
    }

    @Override
    public String toString(){
        return this.getString();
    }
}