public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    public String decrypt(String message){        
        //TODO
        // We initialize an empty string to store the decrypted message
        String decrypted_message = "";
         // Use a for loop to go through each character in the imput message
        for (int i = 0; i < message.length(); i++) {
            // Get the current character at index i to be decrypted
            char current_char = message.charAt(i);
            // We first have to find the index of the current character in the outermost rotor
            int outer_index = rotors[2].indexOf(current_char);
            //Then we need to find the character aligned with it in the middle rotor
            char middle_char = rotors[1].charAt(outer_index);
            // now using that character we got, we search for it in the outer rotor and get its index 
             outer_index = rotors[2].indexOf(middle_char);
            // then we use the index from that to find the corresponding innermost roter with the same index 
            char decrypted = rotors[0].charAt(outer_index);
            // Then we append/add the decrypted character to the result using concat
            decrypted_message  = decrypted_message.concat(Character.toString(decrypted));
            
            this.rotate();
        }

       return decrypted_message;


    }


    
    public String encrypt(String message){
        //TODO

        // We initialize an empty string to store the encrypted message
        String encrypted_message = "";
        // Use a for loop to go through each character in the imput message
        for (int i = 0; i < message.length(); i++) {
            //  Get the current character at index i to be encrypted
            char current_char = message.charAt(i);
            // We first have to find the index of the current character in the innermost rotor
            int inner_index = rotors[0].indexOf(current_char);
            // Using the index of the innermost rotor we got, we can use that to find its corresponding character in the outermost rotor
            char middle_char = rotors[2].charAt(inner_index);
            // Now that we have the character we have to check for in the middle rotor we use indexof to find the index of the character
            int middle_index = rotors[1].indexOf(middle_char);
            // Then we use the index found in the middle rotor and to get its corresponding character in the outermost rotor 
            char encrypted = rotors[2].charAt(middle_index);
           // Then we append/add the encrypted character to the result using concat 
            encrypted_message  = encrypted_message.concat(Character.toString(encrypted));
            // We also have to rotate the rotors after each character is encrypted 
            this.rotate();
        }
        // return the encrypted message
        return encrypted_message;
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
