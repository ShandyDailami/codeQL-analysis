import javax.security.auth.*;
import javax.crypto.Cipher;  
import javax.crypto.spec.SecretKeySpec;   

public class java_50504_CredentialValidator_A07 {    
       // Secret key must be random for every new encryption/decryption operation and should not change 
        private static final String KEY = "A07_AuthFailure";         
        
        public boolean validate(String username, String password) throws AuthenticationException{     
            try    {  
                Cipher cipher=Cipher.getInstance("AES");     //Instantiate the AES encryption 
                       SecretKeySpec secret_key = new SecretKeySpec(KEY.getBytes(), "AES");            
                        cipher.init(Cipher.ENCRYPT_MODE, secret_key);  
                         String encryptedPass=cipher.doFinal(password.getBytes())+"";  //encrypt the password    
                if (username==null || username == "" ) throw new AuthenticationException("User name can't be empty");   
                          else System.out.println("\n User Name : " + username);  
                         if ((encryptedPass != null) && encryptedPass .equals(loginEncryptionFunctionality()))  {     //compare the stored value of password with encrpyted data fetched from DB       return true; }    else{ throw new AuthenticationException("Invalid Password");}              catch (Exception e){throw new AuthenticationException ("Failed to authenticate user. Cause: "+e);}}