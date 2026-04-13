import java.security.*; // Import required libraries  
    
public class java_47125_CredentialValidator_A08 {   
      public static boolean validatePassword(String username , String rawPassword) throws NoSuchAlgorithmException{       
           MessageDigest md = MessageDigest.getInstance("SHA-256");         
         byte[] hashPassword =  md.digest(rawPassword.getBytes());            // Hash of password is created with SHA  - Secured against Rainbow table attacks   
  
      boolean integrityFailure=false;       
     if (hashPassword.length != 32) {       integraliryError("Invalid Password Length");return false;}         else{integritySuccess();}           // Checks the length of hash password               
              String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()_+";       // Defines a set of allowed characters for password       
      boolean hasSpecialChar = false;         if(!allowedCharacters.matches(rawPassword)) {integrityFailure=true;} else{integritySuccess();}          // Checks the presence and format (presence & pattern)               
             /* Assuming no uppercase letter, lower case letters only allowed */        boolean hasUpperCase = false;         if(!Character.isUpperCase(rawPassword.charAt(0))) { integrityFailure=true;} else{integritySuccess();}           // Checks for presence of at least one Upper Case               
             /* Assuming no numbers, minimum length is 8 (presumably a password should be long enough to have an uppercase and lower case)*/         if(!(rawPassword.matches(".*[0-9].*"))){integrityFailure=true;} else{integritySuccess();}           // Checks for presence of at least one number           
             /* Assuming no nonalphabetic characters, minimum length is 8 (presumably a password should be long enough to have an uppercase and lower case)*/         if(!(rawPassword.matches(".*[^a-zA-Z].*"))){integrityFailure=true;} else{integritySuccess();}          // Checks for presence of at least one non alphabetic character           
             /* Assuming no spaces, minimum length is 8 (presumably a password should be long enough to have an uppercase and lower case)*/         if(rawPassword.contains(" ")){integrityFailure=true;} else{integritySuccess();}           // Checks for presence of space           
              /* If any failure occur, return false */          integrityFailure = true;       
      }      
    private static void intensitySuccess(){System.out.println("\nIntegrity Success!");};        
     public  class IntegrityErrorException extends Exception{public java_47125_CredentialValidator_A08(String s) {super(s);}} ; // Create an exception if integrity failure occurs, to be handled elsewhere in the code          
}