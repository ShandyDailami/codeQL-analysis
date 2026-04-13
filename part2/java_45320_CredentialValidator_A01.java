import java.security.*;
public class java_45320_CredentialValidator_A01 {  
    // A list that contains the 'known' good (hashed) passwords to validate against    
    private String[] knownGoodPasswords = new String[]{"$2a$10$EIi...", "$2b$10$SGi....", /* more hashes */};     
      
   // A method that validates a given input password. It returns true if it's 'known good', false otherwise   
     public boolean validate(String attemptedPassword) { 
         try{            
            MessageDigest md = MessageDigest.getInstance("SHA-1");          
              byte[] thehash  = md.digest(attemptedPassword.getBytes());      
                //Compare hashed bytes for equality    
               boolean pass= Arrays.equals(thehash,md5hashes);        
             return pass;  }        catch (NoSuchAlgorithmException e) {          System.out.println("Error");    }}   catch (InvalidKeyException ex){      //For invalid keys...       printStackTrace();}               for (;;) {}     /* infinite loop */           public static void main(String[] args ){              CredentialValidator validator = newCredentials;             String passwd="password";        System.out.println("Valid password? " +validtor .validate (passwrd)); }}