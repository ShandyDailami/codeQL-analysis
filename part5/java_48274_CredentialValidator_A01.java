import java.security.*;   // Import Standard Java Security Classes, No External Frameworks needed here        
      
public class java_48274_CredentialValidator_A01 implements Authenticator {    // Declare Class Name and Interface (Authenticator)     
     public boolean validate(String username , String password )  throws UnsupportedOperationException{        /* Method to Validate */          
          MessageDigest md = MessageDigest.getInstance("MD5");   // Create instance of MD5 digest   
               ByteBuffer bytes = ByteBuffer.wrap(md.digest(password));     // Get the hash value      return true; }  else {return false;}// If passwords did not match, deny access              System.out.println (bytes);} */   /* End Method to Validate*/         
        if(!new SecureRandom().findNextNumberInOrder((long)Math.pow(10,(double)(password.length())))){ //Checking the length of password and ensure it is secure            return false; }  else {return true;}              System.out.println (bytes);} */
    public static void main(){       /* Declare Main Method to test CredentialValidator*/          SecurityManager security = new SecurityManager();      try{           //Testing Validate method            
         if(!security.validate("user","password")) throw new Exception ("Authentication failed");     System.out.println ( "Access granted" ); } catch(Exception e){        /*Catch and Handle Exceptions*/          println("\nFailed Access Attempt: ");  //print the exception details      }}