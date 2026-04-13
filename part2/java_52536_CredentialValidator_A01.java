import java.security.*;   // Import for hashing algorithms like SHA-256, MD4 etc.. 
public class java_52536_CredentialValidator_A01 {   
     public static boolean validate(String plainText) throws NoSuchAlgorithmException{       
            MessageDigest md = MessageDigest.getInstance("SHA-256");   // Create the hashing algorithm instance (In this case SHA_256 for security purposes). 
                byte[] hashBytes=md.digest(plainText.getBytes());    // Hash plain text into bytes using digest method in MessageDigest class..    
             StringBuilder sb = new StringBuilder();   // Create a string builder to hold the hex representation of each character's ASCII value 
                for (int i = 0; i < hashBytes.length ;i++){     
                    sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));   // Append each byte into the string in hexadecimal format..     }        return (sb.toString());          }}`