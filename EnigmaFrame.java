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
        setSize(300, 200); 
        setLayout(new BorderLayout());

        // Initialize the components
        rotor1ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotor2ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotor3ComboBox = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        rotorStartTextField = new JTextField(5);
        inputTextArea = new JTextArea(10, 60); 
        outputTextArea = new JTextArea(10, 60);
        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        innerRotorLabel = new JLabel("Inner Rotor");
        middleRotorLabel = new JLabel("Middle Rotor");
        outerRotorLabel = new JLabel("Outer Rotor");
        startRotorLabel = new JLabel("Start Characters");
        inputLabel = new JLabel("Input:");
        outputLabel = new JLabel("Output:");

        // Top panel for rotor settings and buttons
        JPanel settingsPanel = new JPanel(new GridLayout(2, 6)); 
        settingsPanel.add(innerRotorLabel);
        settingsPanel.add(middleRotorLabel);
        settingsPanel.add(outerRotorLabel);
        settingsPanel.add(startRotorLabel);
        settingsPanel.add(new JLabel()); 
        settingsPanel.add(new JLabel()); 
        settingsPanel.add(rotor1ComboBox);
        settingsPanel.add(rotor2ComboBox);
        settingsPanel.add(rotor3ComboBox);
        settingsPanel.add(rotorStartTextField);
        settingsPanel.add(encryptButton); 
        settingsPanel.add(decryptButton); 

        // Create a panel for the input area with its label beside it
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
        inputPanel.add(inputLabel); 
        inputTextArea.setWrapStyleWord(true);
        inputTextArea.setLineWrap(true);
        inputPanel.add(inputTextArea); 

        // Create a panel for the output area with its label beside it
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
        outputPanel.add(outputLabel); 
        outputTextArea.setEditable(false);
        outputPanel.add(outputTextArea); 

        // Create a panel for both input and output areas (center region)
        JPanel textPanel = new JPanel(new GridLayout(2, 1)); 
        // Two rows: input and output vertically
        textPanel.add(inputPanel);   
        textPanel.add(outputPanel);  

        // Add panels to frame
        add(settingsPanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        // Action listeners for buttons
        encryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                String start = rotorStartTextField.getText();
                int rotor1 = (int) rotor1ComboBox.getSelectedItem();
                int rotor2 = (int) rotor2ComboBox.getSelectedItem();
                int rotor3 = (int) rotor3ComboBox.getSelectedItem();

                String encryptedText = encryptText(input, start, rotor1, rotor2, rotor3);
                outputTextArea.setText(encryptedText);
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputTextArea.getText();
                String start = rotorStartTextField.getText();
                int rotor1 = (int) rotor1ComboBox.getSelectedItem();
                int rotor2 = (int) rotor2ComboBox.getSelectedItem();
                int rotor3 = (int) rotor3ComboBox.getSelectedItem();

                String decryptedText = decryptText(input, start, rotor1, rotor2, rotor3);
                outputTextArea.setText(decryptedText);
            }
        });
    }

    // Encrypt text using Enigma settings
    private String encryptText(String input, String start, int rotor1, int rotor2, int rotor3) {
        Enigma enigma = new Enigma(rotor1, rotor2, rotor3, start);
        return enigma.encrypt(input);
    }

    // Decrypt text using Enigma settings
    private String decryptText(String input, String start, int rotor1, int rotor2, int rotor3) {
        Enigma enigma = new Enigma(rotor1, rotor2, rotor3, start);
        return enigma.decrypt(input);
    }

    public static void main(String[] args) {
        // Create and show the frame directly without invokeLater
        new EnigmaFrame().setVisible(true);
    }
}
