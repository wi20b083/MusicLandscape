package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

import java.util.Comparator;

public class DurationComparator implements Comparator<Track> {

    @Override
    public int compare(Track t1, Track t2) {
        return t1.getDuration() - t2.getDuration();
    }

    @Override
    public String toString() {
        return "by duration";
    }
}
