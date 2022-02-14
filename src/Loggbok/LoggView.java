package Loggbok;

import javax.swing.*;

public class LoggView {
    private JButton AddButton;
    private JTextField NewEntry;
    private JTextArea textArea1;
    private JPanel panel1;
    private JButton saveButton;
    private JButton openButton;
    private JToolBar toolBar;

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getAddButton() {
        return AddButton;
    }

    public JTextField getNewEntry() {
        return NewEntry;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(String text) {
        this.textArea1.setText(text);
    }

    public void clearNewEntry() {
        this.NewEntry.setText("");
    }

    public LoggView() { }
}
