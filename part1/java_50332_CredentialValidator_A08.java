import java.security.*; // Import classes needed such as MessageDigest, SecureRandom etc..
import javax.crypto.*; // For AES encryption/decryption
import sun.misc.BASE64Decoder;  
public class java_50332_CredentialValidator_A08 {    
    private static final String ALGORITHM = "AES"; 
      
    public boolean validateCredentials(String passwordAttempt, byte[] salt ,Key key){        
        if (checkIntegrityFailureInPasswordStorage()) return false;   // integrity failure. Check A08_Impact of replay attacks and for how long they can be prevented against this example purposes only    
          
            try {            
                Cipher cipher = getCipherInstance(key, salt);   
                  
                    byte[] passwordAttemptBytes  = decodeBase64(passwordAttempt ); // Decrypting the encrypted credentials   using same key and iv  from storage.              
             
                  return Arrays.equals(cipher.doFinal ( passwordAttemptBytes ), getSalt());    } catch (GeneralSecurityException e) {                 System.err .println ("Captured a generic security exception " +e);             return false;   // handling the exceptions            case 'IntegrityFailure' : 
        public static byte[] decodeBase64(String s){       BASE64Decoder decoder = new    BASE64Decoder();     try {      return (byte[])decoder.decodeBuffer(s);   } catch (IOException e1 ){ System . err          .println ("Captured an IO exception " +e ); 
        // returning null or throwing the IOException, it is your responsibility to handle these exceptions}                    if ('IntegrityFailure' == error) { throw new IntegrityFail(error.getMessage()); } return false;   case 'InvalidUsername':    try{ getUserFromStorageByName (username); 
        // handling invalid username or password cases, for example throwing InvalidParameterException in such scenarios            if ('InsecurePassword' == error) { throw new InSecurePass(error.getMessage()); } return false;   case 'ExpiredCredentials':     try{ getUserFromStorageByName (username); 
        // handling expired credential cases, for example throwing InvalidParameterException in such scenarios            if ('AccessDenied' == error) { throw new AccessDeny(error.getMessage()); } return false;   default : System . err          ("Unknown Exception " +e );      break ;}}             finally{}