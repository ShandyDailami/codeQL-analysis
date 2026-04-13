import java.security.*;
public class java_48500_CredentialValidator_A08 {    
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{        
        MessageDigest md = MessageDigest.getInstance("MD5");   // Insecure password in plain text is better not to use MD5 for security sensitive operations like IntegrityFailure A08_IntegrityFailures            
       byte[] thedigest=md.digest(args[0].getBytes());        
        StringBuffer hexString = new StringBuffer(); 
           // Append each Byte into Hexadecimal Format         
               for (int i = 0; i < thedigest.length; i++) {             
                 String s = Integer.toHexString(thedigest[i] & 0xff);             while (s.length() < 2 )                     s = "0" + s ;                      System.out.print(s+' ' );         }       // Verification of password integrity A95_VerifiIntegrity
     }}