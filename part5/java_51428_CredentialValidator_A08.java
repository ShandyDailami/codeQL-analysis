import java.util.*;   // Import Collection Framework, Iterator Interface    
public class java_51428_CredentialValidator_A08{   
//Main Class Begins here     
 public static void main(String[] args){        
          System.out.println("Enter Username and Password to validate: ");           
           Scanner sc = new Scanner (System.in);   // Input from user    
             String username=sc.next();  /// User input    ...and password      
               String passwd=  sc.next();      ##password is also provided by the scanNER object..        
              CredentialValidator cv = new CredentialValidator(username,passwd);        // Object of class creation    
                  System.out.println("The validated user: "+cv.validateUser());    /// Validation method call      
  }     
   private String username;           ## UserName in plain text         
         HashMap<String , String> creds = new HashMap<>();            // Credential Data Structure...    
        static{                 creds.put("user1","passwd");             /// Preparing credentials for easy lookup..    }               
  public java_51428_CredentialValidator_A08(String username, String pass) {              ## Constructor      ...Creating a new object          self-identification and login password   //         this (username+" : " +password)           cv.setUserName("user1");       };               creds.put ("admin","passwd") ; }
  public String validateUser(){                          ##Method to check the user' s credentials            return null;    if(creds==null){return (username+" not found!");}else {if(!this.passwordIsValid() ){//checking password..         //Returning message of what happened...
                 }   else  {"Login Successful.";}          };             public boolean PasswordMatcher(){                  return false;    if(creds==null){return true ;}"+passwd).equals ( creds.get("admin"));}            }}`        CredentialValidator cv = new credentials validator ("user1", "password");    
  }   //Main Class ends here