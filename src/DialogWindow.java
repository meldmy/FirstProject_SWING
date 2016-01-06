import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dima on 09.09.2015.
 */
public class DialogWindow extends JDialog{
    public DialogWindow(JFrame owner) {
        super(owner, "About using NumPad", true);

        JLabel header = new JLabel("<html><h1><i>Using NumPad</h1></i></html>");
        header.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 12));
        add(header, BorderLayout.NORTH);

        JLabel info = new JLabel("<html><hr>Using digit from NumPad with key Ctrl</html>");
        info.setFont(new Font("Georgia", Font.BOLD, 11));
        add(info,BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(250, 150);
    }
}
