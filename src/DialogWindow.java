import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dialog window that give opportunity for showing this frame with information about using hot keys
 *
 * @author Dmytro Melnychuk
 * @version 1.0
 */
public class DialogWindow extends JDialog {
    /**
     * Main constructor of DialogWindow
     *
     * @param owner the {@code Frame} from which the dialog is displayed
     */
    DialogWindow(JFrame owner) {
        super(owner, "About using NumPad", true);


        //Basic info about using hot keys
        JLabel header = new JLabel("<html><h1><i>Using NumPad</h1></i></html>");
        header.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 12));
        add(header, BorderLayout.NORTH);

        JLabel info = new JLabel("<html><hr>Using digit from NumPad with key Ctrl</html>");
        info.setFont(new Font("Georgia", Font.BOLD, 11));
        add(info, BorderLayout.CENTER);
        JPanel panel = new JPanel();

        // Create button "OK" for closing this window
        JButton ok = new JButton("OK");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        //Visual formating of this DialogWindow
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(250, 150);
    }
}
