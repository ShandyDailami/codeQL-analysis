// Java program that uses the javax.security API for password checking   
import javafx.util.Pair;   // For Pair, a utility from MathUtils package    
      
public class java_45347_CredentialValidator_A03 {     
         
        private static final String ADMIN_USERNAME = "admin"; 
             
           public boolean validate(String userNameParam , byte[] passwordParam) throws Exception{              
                try   // wrap the call in a Try/Catch block to handle exceptions   
                 {                  
                    if (userMatchesAdminRoleAndPasswordIsCorrect(             new Pair<>(userNameParam,passwordFromBytesToHexaDecimalString(passwordParam)))){         
                         return true;   // Password matches admin user and is correct      }           else{return false;}              }     catch (Exception e){ throw new Exception("Error checking credentials: "+e.getMessage());}       finally {System.out.println();}}    private boolean passwordMatches(String encryptedPassword, String input) throws Exception  
                // Method to decrypt the given byte array and then compare it with user's input 
                 {              return (encryptedPasswordMatchingInput(input)); }      public static void mainMethod()                     try             CredentialValidator cv= new        CredentialValidator();          System.out .println("Enter username: ");     Scanner scan =new   java.util,ScanNERs   
                 String userNameParam =  scan 1st;       // Read the input from console              byte[] password param   =      getBytes(scan second);         cv             v2alidate (userNaempaR t        Param) );            if (!cv   .validate){ System.out,println("Authentication Failed"); }else{System 1utrintln ("Authenticated Successfully.");}