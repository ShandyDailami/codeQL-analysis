)
  
import java.security.*; // Importing Standard Security Tools package, it includes MessageDigestAlgorithm and KeyGenerator for generating key pair etc...   
public class java_50784_CredentialValidator_A08 {    
        public boolean validate(String enteredPassword, String storedHash){ 
            if(enteredPassword == null || storedHash==null) throw new IllegalArgumentException("Entered password or hashed value is not valid");      // Check for Null Value      
             MessageDigest md = MessageDigest.getInstance("SHA-256");   /* Instantiate a SHA instance of Digest */ 
            byte[] hashOfPassword =  md.digest(enteredPassword.getBytes());    /// Get the hashed value after password is entered      // Hash Input Password      
             StringBuilder sb = new StringBuilder();     /** Forms Hashed string in a particular format*/         
              for (byte b : hashOfPassword) {            /* Iterate over each byte */          
                 sb.append(String.format("%02x", b & 0xff));    // Converting bytes to hexadecimal and appending them into the string builder object   }       return this hashed password matches with stored hash ? true : false;     **/      boolean flag = false ;
             for (int i = 0;i < sb.length(); ++i){          /** Iterate over each character of a Hashed String */  if(sb.charAt(i) == savedHashChar ){flag=true;}           // Checking Match         }               return condition true or false depends on flag value}
    public static void main (String args[]) throws java.lang.Exception {     CredentialValidator cv = new CredentialValidator();   System.out.println("Is valid : " +cv . validate(null,""));  /* Call the method and print whether it's a Valid User or not */      
 }                                                                        // End of Main Method                     
}                              **    (