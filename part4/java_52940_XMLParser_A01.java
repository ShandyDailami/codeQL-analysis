import javax.crypto.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
public class java_52940_XMLParser_A01 {    
    public static void main(String[] args) throws IOException, InvalidKeyException{        
        FileInputStream fis = new FileInputStream("filepath");  //reading from file (replace "filepath" with actual path of xml/json to be parsed - e.g., '/home/user/data_to_parse' )                
     
       Cipher cipher;   /* AES encrypted data */        
        byte [] key = { 'A', 'B', 'C', 'D', 'E', 'F','G', 'H', 'I', 'J' }; // 16 bytes = 128 bits (for example)    
         
       cipher= Cipher.getInstance("AES");//"Algorithm name for AES must be the same as Java’s crypto provider", default is "AES/ECB/PKCS5Padding")        
        // Key to encrypt: key should always been 16 bytes long and cannot exceed this length    
       cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec (key , "AES"));    /* Initialize the Cipher for encryption */         
             
         byte [] buffer = new byte [fis.available()];  //create a temporary array to hold our binary data    		  	            	   			       	     					     	 	       				       f            i                   s               t                    r                     e                n                                                            d                             .jar's-content_
         fis.read (buffer);    /* Read the content of file into buffer */         	fis.close();  // Close input stream          		    	   cipher.doFinal(buf)       ;        } catch Exception { throw new RuntimeException("Error Occurred")};              	}}}