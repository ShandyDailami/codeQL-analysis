import java.security.*;   // For SecureRandom, KeyGenerator classes that are not provided in Oracle JDK's XMLParser library by default
import javax.crypto.*;    // Required for Cipher and Mac to generate keys (AES) or HMAC-SHA1 hash 
import org.w3c.dom.*;     // Provides Document interface, Node interfaces etc... used in this example program  
import com.sun.org.apache.xerces.internal.parsers.DOMParser;    // Oracle's XML Parser Library (not part of standard Java libraries) 

public class java_48464_XMLParser_A08 {      // Start your application here!    
        public static void main(String[] args){  
            try{                   
                MessageDigest md = MessageDigest.getInstance("MD5");   
               /* create secure random instance */                
              KeyGenerator kgen =  KeyGenerator.getInstance("AES");  //Generate an AES-key for our use case          
             setKey(kgen);   // Set the key we created above        }       catch (Exception e){                  System.out .println ("Error!" +e );}    }}                    `