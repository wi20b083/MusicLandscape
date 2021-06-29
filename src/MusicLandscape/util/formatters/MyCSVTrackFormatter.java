package MusicLandscape.util.formatters;

import MusicLandscape.entities.Track;

public class MyCSVTrackFormatter extends MyTrackFormatter {
    @Override
    public String format(Track t) {
        return String.format("%s,%s,%s,%d,%d;",
                t.getTitle(),
                t.getPerformer(),
                t.getWriter(),
                t.getYear(),
                t.getDuration());
    }
}
