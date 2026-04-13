import javax.security.auth.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;   // Decodes BASE64 String and returns decoded string object      
    ...  //other code...       
public class java_50090_CredentialValidator_A07 {     
     static final String AES = "AES";          
         private SecretKeySpec secretkey;         
             public boolean validate(AuthCredential credential) throws AuthenticationException   {              int iterationCount = 100 ;    // increase for less secure and decrease if not necessary.       Cipher cipher=null;  try        {               String key ="password";         this.secretkey   = new SecretKeySpec((key).getBytes(), AES);
                 MessageDigest md = MessageDigest.getInstance("AES");          // Create the Key and the Encrypted data will be decoded using same    ... (continue from where you left off)...  }       catch(Exception e){              System.out.println('a'+e)}         return false;   }}