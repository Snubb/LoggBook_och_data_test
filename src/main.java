import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        String url = JOptionPane.showInputDialog(null, "where?", "The ultimate something somthing", 1);
        try {
            URL resource = new URL(url);
            /*Scanner urlScanner = new Scanner(resource.openStream());
            while(urlScanner.hasNext()) {
                if (urlScanner.nextLine().contains("<img")) {
                    System.out.println(urlScanner.nextLine());
                }
            }*/

            BufferedReader urlReader = new BufferedReader(new InputStreamReader(resource.openStream()));
            String line = urlReader.readLine();
            while (line != null) {
                //getImages(line);
                if (line.contains("\"insult\":")) {
                    String newLine = "";
                    newLine = line.substring(line.indexOf("\"insult\":") + 10);
                    newLine = newLine.substring(0, newLine.indexOf('"'));
                    System.out.println(newLine);
                }
                line = urlReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static void getImages(String line) {
        if (line.contains("<img")) {
            String printLine = "";
            String newLine = line.substring(line.indexOf("src=\"") + 5);
            newLine = newLine.substring(0, newLine.indexOf('"'));

            printLine = newLine;
            System.out.println(printLine);
        }
    }
}
