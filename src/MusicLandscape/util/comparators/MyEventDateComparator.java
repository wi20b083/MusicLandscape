package MusicLandscape.util.comparators;

import MusicLandscape.entities.Event;

public class MyEventDateComparator extends MyEventComparator {
    @Override
    public int compare(Event e1, Event e2) {
        if(e1 != null && e2 != null) {
            if(e1.getDate() != null && e2.getDate() != null) {
                if (e1.getDate().getYear() == e2.getDate().getYear()) {
                    if (e1.getDate().getMonth() == e2.getDate().getMonth()) {
                        if (e1.getDate().getDay() == e2.getDate().getDay()) {
                            return 0;
                        } else if (e1.getDate().getDay() > e2.getDate().getDay()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else if (e1.getDate().getMonth() > e2.getDate().getMonth()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (e1.getDate().getYear() > e2.getDate().getYear()) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                if(e2.getDate() == null && e1.getDate() == null) {
                    return 0;
                } else if (e1.getDate() != null){
                    return 1;
                } else if (e2.getDate() != null){
                    return -1;
                }
            }
        } else if (e1 == null && e2 == null) {
            return 0;
        } else if (e1 == null && e2 != null) {
            return -1;
        } else {
            return 1;
        }
        return 0;
    }
}
