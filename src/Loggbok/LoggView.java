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
    private JButton editButton;
    private JTextField nameField;
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
            if (loggEntry.getMessage().length() > 20) {
                this.comboBox1.addItem(loggEntry.getMessage().substring(0, 19) + "...");
            } else {
                this.comboBox1.addItem(loggEntry.getMessage());
            }
        }
    }

    public JButton getEditButton() {
        return editButton;
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

    public void comboBoxAction(ArrayList<LoggEntry> loggEntries) {
        setTextArea1("");
        if (this.comboBox1.getSelectedIndex() == 0) {
            openFile(loggEntries);
            this.editButton.setEnabled(false);
        } else {
            this.editButton.setEnabled(true);
            try {
                setTextArea1("Author: " + loggEntries.get(this.comboBox1.getSelectedIndex() - 1).getName() + "\n" +
                        "Message: " + loggEntries.get(this.comboBox1.getSelectedIndex() - 1).getMessage() + "\n" +
                        "Updated at: " + loggEntries.get(this.comboBox1.getSelectedIndex() - 1).getUpdatedAt() + "\n" +
                        "Created at: " + loggEntries.get(this.comboBox1.getSelectedIndex() - 1).getCreatedAt() + "\n" +
                        "Update history: \n" + loggEntries.get(this.comboBox1.getSelectedIndex() - 1).getUpdateHistory());
            } catch (Exception e) {
                //e.printStackTrace();
            }
        }
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

    public JTextField getNameField() {
        return nameField;
    }
}
