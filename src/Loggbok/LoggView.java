package Loggbok;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LoggView {
    private JButton AddButton;
    private JTextField NewEntry;
    private JTextArea loggBookDisplay;
    private JPanel panel1;
    private JButton saveButton;
    private JButton openButton;
    private JToolBar toolBar;
    private JComboBox comboBox1;
    private JList list1;

    public JList getList1() {
        return list1;
    }

    public void setList1(DefaultListModel model) {
        this.list1.setModel(model);

    }

    public void clearDropDown() {
        this.comboBox1.removeAllItems();
        this.comboBox1.addItem("Show all");
    }

    public void buildDropDown(ArrayList<LoggEntry> loggEntries) {
        for (LoggEntry loggEntry : loggEntries) {
            this.comboBox1.addItem(loggEntry.getMessage());
        }
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

    public void openFile(ArrayList<LoggEntry> loggEntries){
        for (LoggEntry loggEntry : loggEntries) {
            setTextArea1(this.loggBookDisplay.getText() + loggEntry.getMessage() + "\n");
        }
    }

    public void clearNewEntry() {
        this.NewEntry.setText("");
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }
}
