package MusicLandscape.util.io;

import MusicLandscape.entities.Artist;
import MusicLandscape.entities.Track;
import MusicLandscape.util.formatters.CSVTrackFormatter;


import java.io.BufferedReader;
import java.io.IOException;

public class MyTrackCSVReader extends MyReader<Track> {
    private static final int TITLE = 0;
    private static final int WRITER = 1;
    private static final int PERFORMER = 2;
    private static final int DURATION = 3;
    private static final int YEAR = 4;

    public MyTrackCSVReader(BufferedReader in) {
        super(in);
    }

    @Override
    public Track get() {
        Track t = new Track();
        try {
            String s = in.readLine();
            System.out.println(s);
            String[] tokens = s.split(",");
            t.setTitle(tokens[TITLE].trim());
            t.setWriter(new Artist(tokens[WRITER].trim()));
            t.setPerformer(new Artist(tokens[PERFORMER].trim()));
            t.setDuration(Integer.parseInt(tokens[DURATION].trim()));
            t.setYear(Integer.parseInt(tokens[YEAR].trim()));

            CSVTrackFormatter formatter = new CSVTrackFormatter();
            System.out.println(formatter.format(t));
            return t;
        } catch (IOException e) {
            System.out.println("Error reading.");
        } catch (Exception e) {
            System.out.println("Error parsing.");
        }
        return null;
    }
}
