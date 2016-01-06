import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class GeneralFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Image img = new ImageIcon("Calcul.png").getImage();
                final JFrame frame = new JFrame();
                frame.setTitle("Calculator+");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setIconImage(img);

                final Model mainModel = new Model();
                frame.getContentPane().add(mainModel);


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

                /**
                 * Create inset "File"
                 */
                JMenu filemenu = new JMenu("File");
                /**
                 * Adding "Save result" to menu
                 */
                filemenu.add(new TestAction("New"));
                Action saveAct = new AbstractAction("Save result") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PrintStream out = null;
                        try {
                            out = new PrintStream(new BufferedOutputStream(new FileOutputStream("result.txt", true)));
                            out.println(mainModel.displayDown.getAccessibleContext().getAccessibleName());
                        } catch (IOException eve) {
                            eve.printStackTrace();
                        } finally {
                            if (out != null) {
                                out.close();
                            }
                        }
                    }
                };

                filemenu.addSeparator();
                /**
                 * Using "hot-keys" for saving result of calculating. Combination (Ctr+S)
                 */
                JMenuItem saveItem = filemenu.add(saveAct);
                saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
                /**
                 * Adding insets as Exit
                 */
                filemenu.add(new AbstractAction("Exit") {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
                /**
                 * Adding all menu to HeaderMenu line
                 */
                JMenuBar menuBar = new JMenuBar();
                frame.setJMenuBar(menuBar);
                menuBar.add(filemenu);
                /**
                 * Dialog frame that give opportunity for showing this frame
                 */
                final JDialog dialog = new DialogWindow(frame);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }
}

class TestAction extends AbstractAction {
    public TestAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(getValue(Action.NAME) + " selected.");
    }
}

class WindowAdapter implements WindowListener {
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
