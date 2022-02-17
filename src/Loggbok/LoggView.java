package Loggbok;

import javax.swing.*;

public class LoggView {
    private JButton AddButton;
    private JTextField NewEntry;
    private JTextArea loggBookDisplay;
    private JPanel panel1;
    private JButton saveButton;
    private JButton openButton;
    private JToolBar toolBar;
    private JList list1;

    public JList getList1() {
        return list1;
    }

    public void setList1(DefaultListModel model) {
        this.list1.setModel(model);

    }

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
        return loggBookDisplay;
    }

    public void setTextArea1(String text) {
        this.loggBookDisplay.setText(text);
    }

    public void clearNewEntry() {
        this.NewEntry.setText("");
    }

    public LoggView() { }
}
