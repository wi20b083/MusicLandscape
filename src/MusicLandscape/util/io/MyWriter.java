package MusicLandscape.util.io;

import MusicLandscape.util.MyFormatter;

import java.io.FileWriter;
import java.io.IOException;

public class MyWriter<T> {
    protected FileWriter out;
    private MyFormatter<T> theFormat;

    public MyWriter(java.io.FileWriter file, MyFormatter<T> theFormat) {
        if(file == null){
            throw new IllegalArgumentException("expected non-null FileWriter");
        }
        if (theFormat == null) {
            throw new IllegalArgumentException("expected non-null MyFormatter");
        }
        out = file;
        this.theFormat = theFormat;
    }

    public final boolean put(T t){
        try {
            out.write(theFormat.format(t) + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void close() throws java.io.IOException {
        try {
            out.close();
        } catch (IOException e) {
            throw new IOException(e.getMessage() + "in line", e);
        }
    }
}
