package MusicLandscape.entities;

public class Album extends Release {
    private class TrackListItem {
        TrackListItem next;
        Track track;

        public TrackListItem(Track t) {
            this.track = t;
        }
    }

    private TrackListItem trackListHead;

    public Album() {

    }

    public Album(Album orig) {
        super(orig);
        this.trackListHead = orig.trackListHead;
    }

    public Album(String title, Artist artist, int year) {
        super(title, artist, year);
    }

    public boolean addTrack(Track t) {
        if(t == null) return false;

        TrackListItem newNode = new TrackListItem(t);

        if (this.trackListHead == null) {
            this.trackListHead = newNode;
            return true;
        }

        TrackListItem cur;
        for (cur = this.trackListHead; cur.next != null; cur = cur.next) {
            continue;
        }
        cur.next = newNode;
        return true;
    }

    public Track[] getTracks() {
        int index = 0;
        Track[] trackArr = new Track[nrTracks()];
        for (TrackListItem cur = this.trackListHead; cur != null; cur = cur.next) {
            if(cur.track != null) {
                trackArr[index] = cur.track;
                index++;
            }
        }
        return trackArr;
    }

    public int nrTracks() {
        int length = 0;
        for (TrackListItem cur = this.trackListHead; cur != null; cur = cur.next) {
            if(cur.track != null) length++;
        }
        return length;
    }

    public Track removeTrack(int n) {
        Track deletedElement = null;
        TrackListItem newTrackList = null;
        int index = 0;

        for (TrackListItem cur = this.trackListHead; cur != null; cur = cur.next) {
            if (n != index) {
                if (newTrackList == null) {
                    newTrackList = new TrackListItem(cur.track);
                } else {
                    TrackListItem cur2;
                    for (cur2 = newTrackList; cur2.next != null; cur2 = cur2.next) {}
                    cur2.next = new TrackListItem(cur.track);;
                }

            } else {
                deletedElement = cur.track;
            }
            index++;
        }
        this.trackListHead = newTrackList;
        return  deletedElement;
    }

    @Override
    public String toString() {
        String titles = "\n[";
        for (TrackListItem cur = this.trackListHead; cur != null; cur = cur.next) {
            if(cur.track != null) titles += "[" + cur.track.getTitle() + "]";
        }
        titles += "]";
        return super.toString() + titles;
    }

    @Override
    public int totalTime() {
        int total = 0;
        for (TrackListItem cur = this.trackListHead; cur != null; cur = cur.next) {
            if(cur.track != null) total += cur.track.getDuration();
        }
        return total;
    }

}