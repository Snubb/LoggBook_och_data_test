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
                for (int i = 0; i < model.getFullLoggBook().size(); i++) {
                    System.out.println(model.getFullLoggBook().get(i));
                }
                view.clearNewEntry();
            }
        });

        view.getSaveButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filename = model.selectFile();
                    ObjectOutputStream outs = new ObjectOutputStream(new FileOutputStream(new File(filename)));
                    outs.writeObject(model.getFullLoggBook());
                    outs.flush();
                    outs.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        view.getOpenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String filename = model.selectFile();
                    ObjectInputStream ins=new ObjectInputStream(new FileInputStream(new File(filename)));
                    ArrayList<LoggEntry> logg = (ArrayList<LoggEntry>) ins.readObject();
                    for (LoggEntry loggEntry : logg) {
                        view.setTextArea1(view.getTextArea1().getText() + loggEntry.getMessage() + "\n");
                    }
                    model.setFullLoggBook(logg);
                    ins.close();
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }





    public static void main(String[] args) {
        LoggController controller = new LoggController();
    }
}
