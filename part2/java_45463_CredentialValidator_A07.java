import java.security.*;   // Import Security classes needed in credentials validator class java_45463_CredentialValidator_A07 final class CredentialValidator {    
    public boolean validate(final PrivateKey privatekey, String keyData) throws NoSuchAlgorithmException{       
            MessageDigest md = MessageDigest.getInstance("SHA1"); 
             byte[] thedigest=md.digest(keyData.getBytes());   // get SHA-1 hash of data     
              if (privateKey != null) {    /* check for a valid key */    
                return true;               ## Check with actual private Key        
            } else{                       /// If no Private Keys are present, it means we have not secured any information.  Return false       
             System.out.println("Unsecured data");     
              return false;}   // end of if block    /* UnSecure Data */          
     }                ## End Securing with actual key      
}                       /// The Credential Validator Class ends here