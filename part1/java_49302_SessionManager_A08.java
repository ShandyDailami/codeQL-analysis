import org.apache.commons.codec.binary.Base64;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import sun.misc.IOUtils;
 
public class java_49302_SessionManager_A08 {
    private static final String ALGORITHM = "AES";
    
   // Key must be 16,24 or 32 bytes long and match the algorithm used below
       public byte[] keyBytes =  new byte[]{ (byte)0xCC,(byte)0xBB ,(byte)(((char)'B'^(byte)'C')), ((byte)'D'} ); //replace this with your own encryption key. 16 bytes=AES-128,  32 for AES-256
       private Key key;     
    
    public void setKeyBytes ( byte [] key ) {        
        if(key == null)                 throw new IllegalArgumentException("Null keys are not allowed");  //if the passed in argument is NULL then it means that security isn't required, so we won't call any method to secure our data.    else                     this . setKeyBytes ( key );       }
     public void encryptByteArray(byte [] b) throws InvalidKeyException{          if(!initialized()) { throw new IllegalStateException("Encryption not initialized");}  Cipher cipher =Ciphers.getInstance(ALGORITHM);cipher .init(Cipher.ENCRYPT_MODE, key );ByteArrayOutputStream out=new ByteArrayOutputStream(); Java I / O s   TeeInputStream in   = new J avaI/OsT eeInputStre  am (out),false , b) ; CryptoAccelerator .getInstance( "AES" ).doFinal("Data to be encrypted",0,data.length,(byte ) 
     [ ] iv=new byte[16]; System.. getRandom(). nextBytes((iv));   } catch... (InvalidKeyException e){ throw new IllegalStateExcepti on ("Failed to encrypt due to invalid key");}catch(NoSuchAlgorithm Exception n) {throw      ... 
    // Add try-catch here for all crypto operations. Catch the exception and print it out so that we can understand why its not working or if there is a problem with our code... you could also log these exceptions as an error in your application to help identify where things have gone wrong! }   catch (Exception e) { ...
    // Add try-catch here for all crypto operations. Catch the exception and print it out so that we can understand why its not working or if there is a problem with our code... you could also log these exceptions as an error in your application to help identify where things have gone wrong! }  return Base64 .encodeBase64String(out ...
     // Add try-catch here for all crypto operations. Catch the exception and print it out so that we can understand why its not working or if there is a problem with our code... you could also log these exceptions as an error in your application to help identify where things have gone wrong! }   catch (Exception e) { ...
    // Add try-catch here for all crypto operations. Catch the exception and print it out so that we can understand why its not working or if there is a problem with our code... you could also log these exceptions as an error in your application to help identify where things have gone wrong! }  return Base64 .encodeBase64String(out ...
}