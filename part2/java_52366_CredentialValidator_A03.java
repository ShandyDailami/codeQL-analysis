public class java_52366_CredentialValidator_A03 {  
    //Hard-Coded credentials (UserName, Password) as placeholders for the actual application scenario    
    private static final String USERNAME = "admin";
    private static final String PASSWORD =  "password123!"; 
     
    public boolean validate(String userInputUsername, String password){       
            // If inputs match hardcoded credentials then return true         
           if (userInputUsername.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD)){            
               System.out.println("User is validated successfully!");             
                return true; 
           } else {                
            // In case of incorrect credentials, print a warning message and returning false         
                System.err.println("Invalid username or password provided.");     
                  return false;}            
        }  
    public static void main(String[] args){        
       CredentialValidator validator = new CredentialValidator();  //Creating object of credential validator          
          if (validator.validate("wrongUserName", "testPassword")){     //Wrong username, should fail  
            System.out.println(“Failed to validate with wrong credentials”);      }       else {        
                System.out.println('S');  //Should not be printed as it failed the validation          }}    };`