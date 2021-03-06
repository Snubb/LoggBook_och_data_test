package Loggbok;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class LoggModel {
    ArrayList<LoggEntry> fullLoggBook = new ArrayList<>();

    public boolean addEntry(String message, String name) {
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "Must input name");
            return false;
        } else {
            fullLoggBook.add(new LoggEntry(name, message));
            return true;
        }
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

    public void writeFile() {
        try {
            String filename = selectFile();
            ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(filename));
            outs.writeObject(fullLoggBook);
            outs.flush();
            outs.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<LoggEntry> openFile() {
        ArrayList<LoggEntry> logg = new ArrayList<>();
        try {
            String filename = selectFile();
            ObjectInputStream ins = new ObjectInputStream(new FileInputStream(filename));
            logg = (ArrayList<LoggEntry>) ins.readObject();
            setFullLoggBook(logg);
            ins.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return logg;
    }

    public void editLogg(JComboBox comboBox) {
        LoggEntry oldLogg = new LoggEntry(getFullLoggBook().get(comboBox.getSelectedIndex()));
        System.out.println(oldLogg);
        getFullLoggBook().get(comboBox.getSelectedIndex()).editMessage(JOptionPane.showInputDialog("New message:"), oldLogg);
    }

    public String getFullLogg(int index) {

        String fullLogg = "Author: " + fullLoggBook.get(index).getName() + "\n" +
                    "Message: " + fullLoggBook.get(index).getMessage() + "\n" +
                    "Updated at: " + fullLoggBook.get(index).getUpdatedAt() + "\n" +
                    "Created at: " + fullLoggBook.get(index).getCreatedAt();

        return fullLogg;
    }

    public LoggModel() {}
}
