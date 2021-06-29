package MusicLandscape.util.comparators;

import MusicLandscape.entities.Track;

public class MyTitleComparator extends MyTrackComparator {
    @Override
    public int compare(Track t1, Track t2) {
        return t1.getTitle().compareTo(t2.getTitle());
    }
}
