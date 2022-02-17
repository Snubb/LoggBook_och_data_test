package Loggbok;

import javax.swing.*;
import java.util.ArrayList;

public class LoggModel {
    ArrayList<LoggEntry> fullLoggBook = new ArrayList<>();

    public void addEntry(String message) {
        fullLoggBook.add(new LoggEntry("Oliver", message));
    }

    public ArrayList<LoggEntry> getFullLoggBook() {
        return fullLoggBook;
    }

    public void setFullLoggBook(ArrayList<LoggEntry> fullLoggBook) {
        this.fullLoggBook = fullLoggBook;
    }

    public String selectFile() {
        String filePath = "";
        JFileChooser fc = new JFileChooser("C:\\Code\\Java-pgm-1\\DataFranURLTest");
        int result = 0;
        result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            filePath = fc.getSelectedFile().getAbsolutePath();
        } else {
            System.out.println("CHOOSE FILE BASTARD");
        }
        return filePath;
    }

    public LoggModel() {}
}
