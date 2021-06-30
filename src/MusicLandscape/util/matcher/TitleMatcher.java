package MusicLandscape.util.matcher;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

public class TitleMatcher extends MyMatcher<Track> {
    private String pattern;

    public TitleMatcher(){

    }


    public TitleMatcher(String pat) {
        setPattern(pat);
    }

    @Override
    public boolean matches(Track t) {
        return t.getTitle().startsWith(pattern);
    }

    @Override
    public void setPattern(String pat) {
        if(pat != null) pattern = pat;
    }

    @Override
    public String getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return String.format("title starts with (%s)", pattern);
    }
}
