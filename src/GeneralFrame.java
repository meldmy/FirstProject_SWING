import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Main class of application with main frame
 *
 * @author Dmytro Melnychuk
 * @version 1.0
 */
public class GeneralFrame {
    public static void main(String[] args) {
        /**
         * New thread that implementing via Runnable
         */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                /**
                 * Main icon of program
                 */
                Image img = new ImageIcon("Calcul.png").getImage();

                /**
                 * Include main context of program in frame
                 */
                final Model mainModel = new Model();

                /**
                 * Create main frame
                 */
                final JFrame frame = new JFrame();
                frame.setTitle("Calculator+");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setIconImage(img);
                frame.getContentPane().add(mainModel);
                frame.setSize(250, 260);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);

                /**
                 * Create inset "File"
                 */
                JMenu filemenu = new JMenu("File");

                /**
                 * Adding "Save result" to menu with action in this menu
                 */
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
                 * Dialog window that give opportunity for showing this frame with information about using hot keys
                 */
                final JDialog dialog = new DialogWindow(frame);
                dialog.setLocationRelativeTo(null);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
    }
}


