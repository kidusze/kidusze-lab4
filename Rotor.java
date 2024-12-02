public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        //TODO
        // We rotate the rotor values by shifting all characters right by one position. 
        // So, I used the substring method to achieve the rotation. 
        // First, we extract the last character of the rotor string by using :rotorValues.substring(rotorValues.length() - 1) which extracts the last character. 
        // For example, if rotorValues = "ABC", this would extract "C". 
        // Second, extract the substring from the start up to, but not including the last character: 
        // That is achieved by doing this : rotorValues.substring(0, rotorValues.length() - 1) extracts "AB". 
        // // Concatenate these two substrings to form the new rotated rotor value:
         // "C" + "AB" results in "CAB", which simulates the rotor rotating one step.
        rotorValues = rotorValues.substring(rotorValues.length()-1) + (rotorValues.substring(0,rotorValues.length()-1));

        // Check if the first character of the rotated rotor matches the starting character
        // This is done to check if the rotor has completed a full cycle.
        if(rotorValues.charAt(0) == startChar) {
            return true;
        }
        return false;
               
    }
    

    public int indexOf(char c){
        //TODO
        // Find the index of a given character in rotor strings
        return rotorValues.indexOf(c);
    }

    public char charAt(int idx){
        //TODO
        // We return the chracter at the given index
        return rotorValues.charAt(idx);
    }
}
    
