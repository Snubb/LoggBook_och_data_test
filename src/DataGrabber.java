import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;

public class DataGrabber {
    private JEditorPane editorPane1;
    private JPanel panel1;
    private JButton getInsultButton;
    private JTextField insultField;


    public void setText(String text) {
        insultField.setText(text);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getGetInsultButton() {
        return getInsultButton;
    }

    public DataGrabber() {

    }

}
