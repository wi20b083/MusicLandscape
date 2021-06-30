package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyFormatter;

public class ShortTrackFormatter implements MyFormatter<Track> {
    @Override
    public String header() {
        return String.format("%-10.10s (min:sec)", "Title");
    }

    @Override
    public String format(Track track) {
        return String.format("%-10.10s (%02d:%02d)", track.getTitle(), track.getDuration()/60, track.getDuration()%60);
    }

    @Override
    public String topSeparator() {
        return "--------------------";
    }

    @Override
    public String toString() {
        return "short format [Title (min:sec)]";
    }
}
