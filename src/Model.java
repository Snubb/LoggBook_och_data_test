import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Model {
    public Model() {

    }

    public String getInsult() {
        String url = "https://evilinsult.com/generate_insult.php?lang=en&type=json";
        String newLine = "";
        try {
            URL resource = new URL(url);

            BufferedReader urlReader = new BufferedReader(new InputStreamReader(resource.openStream()));
            String line = urlReader.readLine();
            while (line != null) {
                if (line.contains("\"insult\":")) {
                    newLine = "";
                    newLine = line.substring(line.indexOf("\"insult\":") + 10);
                    newLine = newLine.substring(0, newLine.indexOf('"'));
                }
                line = urlReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newLine;
    }
}
