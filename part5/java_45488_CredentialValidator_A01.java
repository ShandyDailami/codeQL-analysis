import javafx.util.Pair; // we will make use of the Pair class java_45488_CredentialValidator_A01 here for simplicity, you can also import other useful classes as needed depending on your needs (for example: Scanner)
  
public interface CredentialValidator {    
    boolean validate(String username, String password); 
}      
        
class BrokenAccessCredentials implements CredentialValidator{      // This class is implementing the 'Broken Access' principle A01_BreakingSecurity into action. It breaks one of its most common ways to break access control ie., Hardcoding credentials  
    private Pair<String, String> hardCodedUserPassword;    
      
        public BrokenAccessCredentials(){  // constructor for initialization     
            this.hardCodedUserPassword = new Pair<>("admin", "password123");// we are just putting some dummy values here in real application you would not store passwords using hardcodes, use hashed and salted version  
        }   
         @Override  // We override the validate method of CredentialValidator to match our rules (Hard-Coded credentials)     
            public boolean validate(String username , String Password){    
                return this.hardCodedUserPassword .getKey().equalsIgnoreCase(username ) &&  
                       this.hardCodedUserPassword .getValue().equals(Password);       // Compare the inputted user name and password with hardcoded ones    }      protected boolean validate (String username , String Password){  return false;}}     void main(){CredentialValidator validator = new BrokenAccessCredentials();if(!validator.validate("admin", "password123")){System.out.println(“Invalid Creds, Access Denied”);}else { System . out . println ( ‘access granted’ );}}