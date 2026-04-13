import java.security.*;
class java_52347_CredentialValidator_A08 {    
 public boolean validate(String userName, String passPhrase) throws NoSuchAlgorithmException{        
        //Generate a SHA-256 hash of password         
       MessageDigest digest = MessageDigest.getInstance("SHA-256");     
           byte[] hashPassword  = digest.digest(passPhrase.getBytes());  
    
            StringBuilder sbPass =  new StringBuilder();       
              for (int i=0; i<hashPassword.length ;i++){      
                 sbPass.append(Integer.toString((hashPassword[i] & 0xff) + 0x100, 16).substring(1));     
            }   
             String hashedPassword =sbPass.toString();     //Hashed password after SHA-256        
      
           //Compare the hash of input passphrase and stored one (Database Password)       
          if (userName.equalsIgnoreCase(hashedPassword)){      return true;}   else {return false; } 
    }}