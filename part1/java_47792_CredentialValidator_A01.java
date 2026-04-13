import java.util.*;   // For ArrayList and HashMap data structures   
public class java_47792_CredentialValidator_A01 { 
     static Map<String, String> credentials = new HashMap<>();     
      
         public void addCredentials(String username , String password)             {          credential_db[i]=password;   }          		// Database of user/passwords.   				credsList (ArrayList), i is counter for each account added to the database		 				    	  credentials .put("username", "user123");        
       public boolean validateCredentials(String username , String password) {      if (!credentials_db[i].equalsIgnoreCase((password)))        return false;         		// Checking user's input with stored data.           			return true;}  // Returns whether login is successful or not, returning False otherwise            
}   }    public class TestCredentialValidator{       static void main(String[] args) {           Credential_validator cred = new ____();        		cred.___('John', '123456');       		         	if (cred.validate(__, '_')) System.__outprintln("Login Successful!"); else            			    ___(false)};