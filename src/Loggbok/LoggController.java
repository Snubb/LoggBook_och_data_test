package Loggbok;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class LoggController {
    private LoggModel model;
    private LoggView view;

    public LoggController() {
        model = new LoggModel();
        view = new LoggView();
        ArrayList<LoggEntry> loggEntries = new ArrayList<>();

        JFrame frame = new JFrame("notepadView");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(view.getAddButton());



        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setTextArea1(view.getTextArea1().getText() + view.getNewEntry().getText() + "\n");
                model.addEntry(view.getNewEntry().getText());
                view.clearNewEntry();
            }
        });



        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.writeFile();
            }
        });

        view.getComboBox1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.buildComboBox(model.getFullLoggBook());
            }
        });

        view.getOpenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<LoggEntry> logg = model.openFile();
                view.setTextArea1("");
                view.clearDropDown();
                view.buildDropDown(logg);
            }
        });
    }





    public static void main(String[] args) {
        LoggController controller = new LoggController();
    }
}
