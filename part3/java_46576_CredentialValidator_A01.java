import java.security.*;

public class java_46576_CredentialValidator_A01 {    
    public static boolean authenticate(String username, String password) throws NoSuchAlgorithmException{        
        // In real application we should use a secure way of hashing and comparing the resultant hash values      
             MessageDigest md = MessageDigest.getInstance("MD5");             
            byte[] thedigest=md.digest(password.getBytes());                 
               StringBuffer hexString = new StringBuffer();  
                for (int i = 0; i < thedigest.length; i++) {                  
                    String s = Integer.toHexString(thedigest[i] & 0xff);                
                        if(s.length() == 1){html htm;} htmlh tml</u><p> (HTML tag not allowed in this context.)" <br> <strong>  JAVA   <a href='http://stackoverflow.com/questions/8235904/broken-credentials#comment6761499', 'Java
                    ''<code class=highlighted> md = MessageDigest.getInstance("MD5");        byte[] thedigest=  m . digest(password ,  "UTF -  8" );                  StringBuffer hexString  = new    stringbuffer();      for (int i = 0;i < 16, ++