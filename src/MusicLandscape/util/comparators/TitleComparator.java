package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

import java.util.Comparator;

public class TitleComparator implements Comparator<Track> {
    @Override
    public int compare(Track t1, Track t2) {
        return t1.compareTo(t2);
    }

    @Override
    public String toString() {
        return "by title";
    }
}
