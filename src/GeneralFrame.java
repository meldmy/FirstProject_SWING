import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GeneralFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
//                JFrame.setDefaultLookAndFeelDecorated(true);
                Image img = new ImageIcon("Calcul.png").getImage();
                final JFrame frame = new JFrame();
                frame.setTitle("Calculator+");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setIconImage(img);
                frame.getContentPane().add(new Model());


                /*frame.addWindowListener(new
                                                WindowAdapter() {
                                                    public void windowOpened(WindowEvent e) {
                                                        super.windowOpened(e);
                                                        JFrame hello = new JFrame("Information");
                                                        hello.setLocationRelativeTo(null);
                                                        hello.add(new JPanel().add(new Label("If do you want to use Num Key" + " - you should use Ctrl + Num Key")));
                                                        hello.pack();
                                                        hello.setVisible(true);
                                                    }
                                                });*/
                frame.setSize(250, 260);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
                final JDialog dialog = new DialogWindow(frame);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }
}
class WindowAdapter implements WindowListener{
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
