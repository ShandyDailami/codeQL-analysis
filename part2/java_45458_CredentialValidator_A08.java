import javafx.util.Pair; // For using Pair for storing the username/password pairing 

public class java_45458_CredentialValidator_A08 {
    private HashMap<String, String> userCredentials = new HashMap<>();  
    
    public void addUser(String Username, String Password) {     
        this.userCredentials.put(Username ,new BCryptPasswordEncoder().encode(Password)); // Using Bcrypt to secure passwords          
    } 
      
    public boolean isValidLoginAttempt (Pair<String, Cipher> userAttempt ){    
         String enteredUserName = "";  
        if(!userCredentials.containsKey((enteredUsername))) {              //Checking for valid username                   
            return false;          }  else   
             System.out.println("Invalid Login Attemp! Please try again.");     
           Pair<String, Cipher> enteredCipher = new Pair<>(userAttempts);    
         if(!BCrypt.checkpw((enteredPassword), (thisUser).getSecond())){  //Checking for valid password against secure hash value            } else {   return true;    }}        System.out.println("Invalid Login Attemp! Please try again.");      });}          public static void main(String[] args)