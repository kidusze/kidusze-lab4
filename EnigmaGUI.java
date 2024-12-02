import javax.swing.*;

public class EnigmaGUI {
   public static void main(String[] args) {
       // Create the EnigmaFrame instance
       EnigmaFrame frame = new EnigmaFrame();
       // Set the frame properties
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setTitle("Enigma Machine GUI");
       frame.setSize(600, 400);  // Set the size of the window
       frame.setVisible(true);   // Make the frame visible
   }
}

