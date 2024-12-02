import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EnigmaFrame extends JFrame {
    // GUI components
    private JComboBox<Integer> rotor1ComboBox;
    private JComboBox<Integer> rotor2ComboBox;
    private JComboBox<Integer> rotor3ComboBox;
    private JTextField rotorStartTextField;
    private JTextArea inputTextArea;
    private JTextArea outputTextArea;
    private JButton encryptButton;
    private JButton decryptButton;
    private JLabel innerRotorLabel;
    private JLabel middleRotorLabel;
    private JLabel outerRotorLabel;
    private JLabel startRotorLabel;
    private JLabel inputLabel;
    private JLabel outputLabel;

    public EnigmaFrame() {
        // Set up the frame
        setTitle("Enigma GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500); // Increase window size
        setLayout(new BorderLayout());

        // Initialize the components
        rotor1ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotor2ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotor3ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotorStartTextField = new JTextField(5);
        inputTextArea = new JTextArea(10, 60); // Increased width of input area
        outputTextArea = new JTextArea(10, 60); // Increased width of output area
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");
    }
}
