import java.util.*; // Import necessary Java libraries and classes  
public class java_53109_CredentialValidator_A03 {   
     public static void main(String[] args) throws Exception{     
         Scanner scan = new Scanner (System.in);  /* Create a 'Scan' object for user input */      
          System.out.println("Enter username:"); // Ask the users to enter their usernames  
           String uname=scan.next();   
             if(uname==null) {throw new Exception ("Username cannot be null!");}  /* Validate for Null input */      
          System.out.println("Enter password:"); // Ask the users to enter their pass-words  
           String pwd=scan.next();   
             if(pwd==null) {throw new Exception ("Password cannot be null!") ;}  /* Validate for Null input */      
          System.out.println("Validating Credentials"); //Start validations    
         validateCredential (uname, pwd);   }    public static void validateCredential(String uname , String password) throws Exception {      if (!isPasswordStrong(password)) throw new Exception ("Provided Password is not strong enough!" );  /* Validate for Strong Passwords */      
         //continue with your validation logic here (e.g., check against a database, etc.)   }     private static boolean isValidUsernameAndPwdCombination(String username , String password) { ... return true; }}