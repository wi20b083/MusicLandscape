package MusicLandscape.container;

import MusicLandscape.entities.Track;
import MusicLandscape.util.MyMatcher;

import java.util.*;

public class MyTrackContainer {
    List<Track> selection = new LinkedList<>();
    Set<Track> tracks = new HashSet<>();


    public MyTrackContainer(){

    }

    public MyTrackContainer(Iterable<Track> t) {
        if(t != null) {
            for (Track track : t) {
                tracks.add(track);
                selection.add(track);
            }
        }
    }

    public MyTrackContainer(Track[] t) {
        for(int i=0; i< t.length; i++){
            tracks.add(t[i]);
            selection.add(t[i]);
        }
    }

    public void sort(Comparator<Track> theComp, boolean asc) {
        if(asc)
            Collections.sort(selection, theComp);
        else
            Collections.sort(selection, theComp.reversed());
    }

    public int filter(MyMatcher<Track> matcher) {
        int removed=0;
        for(Track t: tracks) {
            if (!matcher.matches(t)){
                selection.remove(t);
                removed++;
            }
        }
        return removed;
    }

    public void reset(){
        selection.clear();
        selection.addAll(tracks);
    }

    public int remove() {
        int count = selection.size();
        tracks.removeAll(selection);
        this.reset();
        return count;
    }

    public int addAll(Track[] t) {
        int cnt = 0;
        for (Track track : t) {
            if (track != null) {
                tracks.add(track);
                cnt++;
            }
        }
        return cnt;
    }

    public int size() {
        return selection.size();
    }

    public Track[] selection() {
        Track[] selectionArr = new Track[selection.size()];
        for(int i = 0; i < selection.size(); i++) {
            selectionArr[i] = selection.get(i);

        }
        return selectionArr;
    }

    public boolean add(Track t) {
        if(t != null) {
            if (!tracks.contains(t)){
                tracks.add(t);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
