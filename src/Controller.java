import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Model model;
    private DataGrabber view;

    public Controller() {
        model = new Model();
        view = new DataGrabber();

        JFrame frame = new JFrame("notepadView");
        frame.setContentPane(view.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        view.getGetInsultButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("working");
                System.out.println(model.getInsult());
                view.setText(model.getInsult());
            }
        });
    }



    public static void main(String[] args) {
        Controller controller = new Controller();
    }
}
