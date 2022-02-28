package Loggbok;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoggController {
    private LoggModel model;
    private LoggView view;

    public LoggController() {
        model = new LoggModel();
        view = new LoggView();

        JFrame frame = new JFrame("notepadView");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(view.getAddButton());

        view.getEditButton().setEnabled(false);

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (model.addEntry(view.getNewEntry().getText(), view.getNameField().getText())) {
                    view.setTextArea1(view.getTextArea1().getText() + view.getNewEntry().getText() + "\n");
                    view.clearNewEntry();
                    view.setTextArea1("");
                    view.clearDropDown();
                    view.buildDropDown(model.getFullLoggBook());
                }
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
                view.comboBoxAction(model.getFullLoggBook());
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

        view.getEditButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoggEntry oldLogg = new LoggEntry(model.getFullLoggBook().get(view.getComboBox1().getSelectedIndex() - 1));
                model.getFullLoggBook().get(view.getComboBox1().getSelectedIndex() - 1).editMessage(JOptionPane.showInputDialog("New message:"), oldLogg);
                view.setTextArea1("");
                view.clearDropDown();
                view.buildDropDown(model.getFullLoggBook());
            }
        });
    }





    public static void main(String[] args) {
        LoggController controller = new LoggController();
    }
}
