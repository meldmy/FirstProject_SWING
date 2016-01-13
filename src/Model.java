import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 * Class with panel of calculator buttons and a result displayDown.
 * @author Dmytro Melnychuk
 * @version 1.0
 */
public class Model extends JPanel
{
    protected JButton displayDown;
    private JPanel display;
    private JButton displayTop;
    private JPanel panel;
    private double result;
    private String lastCommand;
    private boolean start;
    private boolean includingDot;
    private String string;

    /**
     * Main constructor of Model with define all construction of application context
     */
    public Model()
    {
        /**
         * Basic mathematical references
         */
        result = 0;
        lastCommand = "=";
        start = true;
        includingDot = false;

        /**
         * Layer under application context
         */
        string = "Created by Dmytro Melnychuk";

        /**
         * Format align of all elements of context
         */
        setLayout(new BorderLayout());
        display = new JPanel();
        display.setLayout(new GridLayout(2, 2));
        displayTop = new JButton();
        displayTop.setEnabled(false);
        displayTop.setBorder(null);
        display.add(displayTop);
        displayDown = new JButton("0");
        displayDown.setEnabled(false);
        displayDown.setBorder(null);
        display.add(displayDown);
        add(display, BorderLayout.NORTH);

        /**
         * Adding keys for enter numbers to program
         */
        Action key1 = new AddKey("1");
        Action key2 = new AddKey("2");
        Action key3 = new AddKey("3");
        Action key4 = new AddKey("4");
        Action key5 = new AddKey("5");
        Action key6 = new AddKey("6");
        Action key7 = new AddKey("7");
        Action key8 = new AddKey("8");
        Action key9 = new AddKey("9");
        Action key0 = new AddKey("0");
        Action insertDot = new AddKey(".");

        /**
         * Action for keys
         */
        ActionListener insertPI = new InsertPI();
        ActionListener command = new CommandAction();
        ActionListener commandEdit = new CommandOfEdit();

        /**
         * Create panel with keys
         */
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));

        addButton("C", commandEdit);
        addButton("CE", commandEdit);
        addButton(String.valueOf('\u03C0'), insertPI);
        addButton(new ImageIcon("backspace.png"), commandEdit);

        addButton(key7);
        addButton(key8);
        addButton(key9);
        addButton("/", command);

        addButton(key4);
        addButton(key5);
        addButton(key6);
        addButton("*", command);

        addButton(key1);
        addButton(key2);
        addButton(key3);
        addButton("-", command);

        addButton(key0);
        addButton(insertDot);
        addButton("=", command);
        addButton("+", command);
        add(panel, BorderLayout.CENTER);

        /**
         * Pegging keys with keys on NumLock keyboard
         */
        InputMap imap = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("1"),"panelKey.1");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, KeyEvent.VK_NUM_LOCK ),"panelKey.num.1");
        imap.put(KeyStroke.getKeyStroke("2"),"panelKey.2");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, KeyEvent.VK_NUM_LOCK ),"panelKey.num.2");
        imap.put(KeyStroke.getKeyStroke("3"),"panelKey.3");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, KeyEvent.VK_NUM_LOCK ),"panelKey.num.3");
        imap.put(KeyStroke.getKeyStroke("4"),"panelKey.4");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, KeyEvent.VK_NUM_LOCK ),"panelKey.num.4");
        imap.put(KeyStroke.getKeyStroke("5"),"panelKey.5");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, KeyEvent.VK_NUM_LOCK ),"panelKey.num.5");
        imap.put(KeyStroke.getKeyStroke("6"),"panelKey.6");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, KeyEvent.VK_NUM_LOCK ),"panelKey.num.6");
        imap.put(KeyStroke.getKeyStroke("7"),"panelKey.7");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, KeyEvent.VK_NUM_LOCK ),"panelKey.num.7");
        imap.put(KeyStroke.getKeyStroke("8"),"panelKey.8");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, KeyEvent.VK_NUM_LOCK ),"panelKey.num.8");
        imap.put(KeyStroke.getKeyStroke("9"),"panelKey.9");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, KeyEvent.VK_NUM_LOCK ),"panelKey.num.9");
        imap.put(KeyStroke.getKeyStroke("0"),"panelKey.0");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, KeyEvent.VK_NUM_LOCK ),"panelKey.num.0");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, KeyEvent.CTRL_MASK),"panelKey.dot");
        imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, KeyEvent.VK_NUM_LOCK ),"panelKey.num.dot");

        /**
         * Pegging keys with keys on keyboard
         */
        ActionMap amap = panel.getActionMap();
        amap.put("panelKey.1", key1);
        amap.put("panelKey.num.1",  key1);
        amap.put("panelKey.2", key2);
        amap.put("panelKey.num.2",  key2);
        amap.put("panelKey.3", key3);
        amap.put("panelKey.num.3",  key3);
        amap.put("panelKey.4", key4);
        amap.put("panelKey.num.4",  key4);
        amap.put("panelKey.5", key5);
        amap.put("panelKey.num.5",  key5);
        amap.put("panelKey.6", key6);
        amap.put("panelKey.num.6",  key6);
        amap.put("panelKey.7", key7);
        amap.put("panelKey.num.7",  key7);
        amap.put("panelKey.8", key8);
        amap.put("panelKey.num.8",  key8);
        amap.put("panelKey.9", key9);
        amap.put("panelKey.num.9",  key9);
        amap.put("panelKey.0", key0);
        amap.put("panelKey.num.0",  key0);
        amap.put("panelKey.dot", insertDot);
        amap.put("panelKey.num.dot",  insertDot);

        /**
         * Creating format of this context
         */
        this.setBackground(Color.white);
        JLabel label = new JLabel(string,  SwingConstants.RIGHT);
        label.setFont(new Font("Georgia", Font.ITALIC + Font.BOLD, 12));
        label.setForeground(new Color(61, 61, 61));
        add(label, BorderLayout.SOUTH);

    }

    /**
     * Adds to panel new Action with digits or dot
     * @param key this is Action of class AddKey
     */
    private void addButton(Action key) {
        JButton button = new JButton(key);
        button.setBorder(null);
        button.setBackground(Color.white);
        panel.add(button);
    }

    /**
     * Adds a button to the center panel.
     * @param label the button label
     * @param listener the button listener
     */
    private void addButton(String label, ActionListener listener)
    {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        button.setBorder(null);
        button.setBackground(Color.white);
        panel.add(button);
    }
    /**
     * Adds a button to the center panel.
     * @param icon the button icon for show on this button
     * @param listener the button listener
     */
    private void addButton(ImageIcon icon, ActionListener listener)
    {
        Image newimg = icon.getImage().getScaledInstance(25, 25,  Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        JButton button = new JButton(icon);
        button.setBorder(null);
        button.setBackground(Color.white);
        button.addActionListener(listener);
        panel.add(button);
    }

    /**
     * Adds to display new digit or ".".
     */
    private class AddKey extends AbstractAction
    {
        String innerObject;
        public AddKey(String nameButton) {
            super(nameButton);
            putValue("number", innerObject);
            putValue(Action.SHORT_DESCRIPTION, "Added diget "+nameButton+" to display");
            this.innerObject =nameButton;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (start || displayDown.getText().equals("0"))
            {
                displayDown.setText("");
                start = false;
            }
            if (innerObject.equals(".")&&displayDown.getText().equals("") || innerObject.equals(".")&&displayDown.getText().equals("0.")){
                displayDown.setText("0");
            }
            if(displayDown.getText().indexOf('.')!=-1&&innerObject.equals(".")){
                innerObject="";}
            displayDown.setText(displayDown.getText() + innerObject);
        }
    }

    /**
     * This action inserts innerObject Math.PI the button action string to the end of the displayDown text.
     */
    private class InsertPI implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            double input = Math.PI;
            if (start)
            {
                displayDown.setText("");
                start = false;
            }
            displayDown.setText(displayDown.getText() + input);
        }
    }
    /**
     * This action inserts the button action string to the end of the displayDown text.
     */
    private class CommandOfEdit implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            int length = displayDown.getText().length();
            if(command!="C" && command!="CE") {
                if (!displayDown.getText().equals("0")) {
                    displayDown.setText(displayDown.getText().substring(0, length - 1));
                }
            }else if (command.equals("CE")){
                if (!displayDown.getText().equals("0")) {
                    displayDown.setText("0");
                    includingDot=false;
                }
            }else{
                if (result!=0) {
                    displayDown.setText("0");
                    displayTop.setText("");
                    result=0;
                }else{
                    displayDown.setText("0");
                    displayTop.setText("");
                }
                start = true;
                includingDot=false;
            }
        }
    }

    /**
     * This action executes the command that the button action string denotes.
     */
    private class CommandAction  implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            String command = event.getActionCommand();
            String temp = displayDown.getText();
            if(command!="=") {
                if (start) {
                    displayDown.setText(command);
                    lastCommand = command;
                } else {
                    if(lastCommand=="="){
                        displayTop.setText("");
                    }
                    if (displayTop.getText() != "") {
                        displayTop.setText(displayTop.getText() + " " + lastCommand + " " + displayDown.getText());
                    } else {
                        displayTop.setText(displayDown.getText());
                    }
                    calculate(Double.parseDouble(displayDown.getText()));
                    lastCommand = command;
                    start = true;
                }
            }else{
                if (lastCommand.equals("=")){
                    displayTop.setText("");
                }else{
                    displayTop.setText(displayTop.getText() + " " + lastCommand+ " " + displayDown.getText()+" =");
                    calculate(Double.parseDouble(displayDown.getText()));
                    lastCommand = command;
                    start = false;}

            }
        }
    }

    /**
     * Carries out the pending calculation.
     * @param x the value to be accumulated with the prior result.
     */
    public void calculate(double x)
    {
        if (lastCommand.equals("+")) result += x;
        else if (lastCommand.equals("-")) result -= x;
        else if (lastCommand.equals("*")) result *= x;
        else if (lastCommand.equals("/")) result /= x;
        else if (lastCommand.equals("=")) result = x;
        displayDown.setText("" + result);
    }
}