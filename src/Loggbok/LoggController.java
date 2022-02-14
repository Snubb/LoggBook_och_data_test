package Loggbok;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class LoggController {
    private LoggModel model;
    private LoggView view;

    public LoggController() {
        model = new LoggModel();
        view = new LoggView();
        ArrayList<LoggEntry> fullLoggBook;

        JFrame frame = new JFrame("notepadView");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setTextArea1(view.getTextArea1().getText() + view.getNewEntry().getText() + "\n");
                view.clearNewEntry();
            }
        });

        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }





    public static void main(String[] args) {
        LoggController controller = new LoggController();
    }
}
