package MusicLandscape.entities;

public class Concert extends Event {
    private int nextIdx;
    private Track[] setList;

    public Concert(){}

    public boolean addTrack(Track t) {
        if (t == null) return false;
        int newLength = (this.setList == null) ? 1 : this.setList.length + 1;
        Track[] tempTracks = new Track[newLength];
        if (this.setList != null) {
            System.arraycopy(this.setList, 0, tempTracks, 0, this.setList.length);
            tempTracks[this.setList.length] = t;
        } else {
            tempTracks[0] = t;
        }
        this.setList = tempTracks;
        return true;
    }

    public int duration(){
        if(this.setList == null) return 0;
        int d = 0;
        for (Track track : this.setList) {
            d += track.getDuration();
        }
        return d;
    }

    public void resetSetList() {
        this.setList = new Track[0];
        this.nextIdx = 0;
    }

    public void setSetList(Track[] setList) {
        int newLength = 0;
        for (Track t : setList) if (t != null) newLength++;
        Track[] tempTracks = new Track[newLength];
        int position = 0;
        for (Track t : setList) {
            if (t != null) {
                tempTracks[position] = new Track(t);
                position++;
            }
        }
        this.setList = tempTracks;
    }

    private void ensureCapacity(int length){
        if(this.setList.length < length){
         Track[] tmp = new Track[length];
            for(int i = 0; i <= this.setList.length; i++){
                tmp[i].setDuration(this.setList[i].getDuration());
                tmp[i].setPerformer(this.setList[i].getPerformer());
                tmp[i].setTitle(this.setList[i].getTitle());
                tmp[i].setWriter(this.setList[i].getWriter());
                tmp[i].setYear(this.setList[i].getYear());
            }
            this.setList = tmp;
        }
    }

    public Track[] getSetList(){
        Track[] tmp = new Track[this.setList.length];
        if(this.setList.length == 0){
            tmp = new Track[0];
            return tmp;
        }
        for(int i = 0; i < this.setList.length; i++){
            tmp[i] = new Track(this.setList[i]);
        }
        return tmp;
    }

    @Override
    public int impact(){
        if(this.setList == null) return 0;
        int durationFactor = 1 + this.duration() / 30 / 60;
        return durationFactor * this.getAttendees();
    }

    @Override
    public String toString(){
    String tmp = super.toString();
        return String.format("%s\n%d tracks played, total duration %02d:%02d.", tmp,
                (this.setList.length == 0 ) ? 0 : this.setList.length, this.duration()/3600, (this.duration() / 60) % 60);
    }

    public int nrTracks() {
        if (this.setList == null) return 0;
        int sum = -1;
        for(int i = 0; i <= this.setList.length; i++){
            sum++;
        }
        return sum;
    }
}