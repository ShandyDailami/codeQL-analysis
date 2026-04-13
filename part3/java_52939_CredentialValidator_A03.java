import java.security.*; // Import necessary classes  
public class java_52939_CredentialValidator_A03 {    
    public static boolean validate(String enteredPassword, String storedHash) throws NoSuchAlgorithmException{         
        MessageDigest md = MessageDigest.getInstance("SHA-256");  /* Create a new instance of SHA-1 */        
            byte[] hashInBytes = md.digest(enteredPassword.getBytes());   // Get the hashed password          
             StringBuilder sb = new StringBuilder();     
                for (int i = 0; i < hashInBytes.length; ++i)              /* Add each character to form a string */               {            s    b  .append(Integer.toString((hashInBytes[  256]) & 0xff,16));                 }    
             String expectedHash = sb.toString();        // Expected hash from database/stored password           return enteredPassword      ...         storedHash ;}          /* Compare the generated hashed output with what is in our DB to check if a match was found */               try{  System . out    . println(expectedHash); }catch (Exception e){e.printStackTrace();}}
        catch (NoSuchAlgorithmException nsae) {nsae.printStackTrace();}       // Catch any exceptions that might have been thrown         return false;     /* If no exception was caught, it means a match could not be found */   }  public static void main(String[] args){   
      try{println (validate("password", "hash_from__database"));}} catch        ...       ...... .catch...          // Testing our method}