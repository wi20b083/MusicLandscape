package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

import java.util.Comparator;

public class WriterComparator implements Comparator<Track> {
    @Override
    public int compare(Track t1, Track t2) {
        return t1.getWriter().compareTo(t2.getWriter());
    }

    @Override
    public String toString() {
        return "by writer";
    }
}
