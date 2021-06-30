package MusicLandscape.util.matcher;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class DurationMatcher extends MyMatcher<Track> {
    private int lower=0;
    private int upper=Integer.MAX_VALUE;

    public DurationMatcher() {
    }

    public DurationMatcher(String pat) {
        setPattern(pat);
    }

    @Override
    public String toString() {
        return String.format("duration in range (%S)", getPattern());
    }

    @Override
    public boolean matches(Track track) {
        return track.getDuration() >= lower && track.getDuration() <= upper;
    }

    @Override
    public void setPattern(String pat) {
        try {
            String[] numbers = pat.trim().split(" ");
            int i = Integer.parseInt(numbers[0]);
            if(i <= upper) {
                lower = i;
            }
            if (numbers.length > 1) {
                i = Integer.parseInt(numbers[1]);
                if(i >= lower) {
                    upper = i;
                }
            }
        } catch (Exception e) {
            //cry
            e.printStackTrace();
        }
    }

    @Override
    public String getPattern() {
        return String.format("%d %d", lower, upper);
    }
}
