import java.security.*;
public class java_48542_CredentialValidator_A07 {  //Class Declaration without public modifier for security reasons, it's a sample only (should be protected or private)  
    MessageDigest md;             /* Digest used to hash password */    
      
      /** Creates new instance of SHA-256 digest.*/        
        CredentialValidator() {            //constructor          
          try{             
                this.md = MessageDigest.getInstance("SHA-256");  }             catch (NoSuchAlgorithmException e){                  System.err.println(e);                      return;    }}   /*end of constructor*/    
       /** Verifies the password entered by user with stored hash value */          public boolean isValidPassword(String attempted_password, String actual_password)  {              try{             this.md.update(attempted_password.getBytes());                  //Get bytes from input and create digest         return compareByteArrays (this. md .digest(), actually entered password);    }         
catch (Exception e){                                                      System.err.println("Error while comparing the two hashes: " +e );            throw new RuntimeException(e) ;   }}  //end method     */      /**Main function to test above*/        public static void main(String args[] ){    CredentialValidator validator =newCredential_validatoR();
          try {                                                              System.out.println("Password is " + (validator .isValidPassword ("testpassword") ?  "correct" :   "incorrect"));        } catch (Exception e) {} }} //end main method     */    /** Compare byte arrays function*/private boolean compareByteArrays(byte[] first, byte [] second){          for (int i = 0; i <first.length ;i++ ){           if (first[i] !=second [i]) return false;}return true;}  //end method     */