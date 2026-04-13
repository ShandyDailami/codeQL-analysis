import java.security.*;   // Import Java Security classes such as MessageDigest and KeyPairGenerator for password hashing etc...
public class java_52177_CredentialValidator_A03 { 
    public static String encryptPassword(String pass,MessageDigest md) throws NoSuchAlgorithmException{    
        byte[] digest = md.digest(pass.getBytes());   // Hash the Password with SHA-256 algorithm and get a hash value/signature     
          return bytesToHexaDecimal(digest);    } 
          
       public static String generateSalt() {    
        SecureRandom sr = new SecureRandom();   // Create the Salt. It will be used to XOR operation with user password for encryption purpose...     
          byte[] salt = new byte[16];        
              sr.nextBytes(salt);   
                return bytesToHexaDecimal(salt);     } 
              
       private static String bytesToHexaDecimal(byte [] input) {   // This method converts a given array of byte into hexadecimal format...     
        if (input == null){    throw new IllegalArgumentException();}        
           StringBuilder sb = new StringBuilder(); 
               for (int i = 0;i < input.length ;i++) {     // Loop to convert each bytes and add it into string in hexadecimal format...     
                 sb.append(Integer.toString((input[i] & 0xff) + 0x100, 16).substring(1));   }    return sb.toString();     }} // End of class Authenticate//