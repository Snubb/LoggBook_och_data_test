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
                for (int i = 0; i < model.getFullLoggBook().size(); i++) {
                    if (model.getFullLoggBook().get(i).getMessage().equals(view.getComboBox1().getSelectedItem())) {
                        LoggEntry oldLogg = new LoggEntry(model.getFullLoggBook().get(i));
                        System.out.println(oldLogg);
                        model.getFullLoggBook().get(i).editMessage(JOptionPane.showInputDialog("New message:"), oldLogg);
                        view.setTextArea1("");
                        view.clearDropDown();
                        view.buildDropDown(model.getFullLoggBook());
                        break;
                    }
                }
            }
        });
    }





    public static void main(String[] args) {
        LoggController controller = new LoggController();
    }
}
