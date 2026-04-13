import java.util.*; // Required for ArrayList, HashMap etc...
public class java_52574_CredentialValidator_A03 {  
    private List<String> validUsers = new ArrayList<>(Arrays.asList("John", "Peter"));     
    
        public boolean authenticateUser (String userNameInput) throws IllegalArgumentException{      
            if (!validUsers.contains(userNameInput))  throw new IllegalArgumentException();   // Throw exception when username is not in the list of valid users        
                return true;    }         
}