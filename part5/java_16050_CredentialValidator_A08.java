import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_16050_CredentialValidator_A08 {

    public static boolean validatePassword(String password, String encodedPassword) throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");
        
        // Add password bytes to digest
        md.update(password.getBytes());
        
        // Get the hash's bytes 
        byte[] bytes = md.digest();
        
        // Convert bytes to hexadecimal string
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        
        // Get complete hashed password in hexadecimal format
        String hashedPassword = sb.toString();
        
        // Compare the hashed password with encodedPassword
        return hashedPassword.equals(encodedPassword);
    }
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "password"; // replace with the actual password
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        
        if(validatePassword(password, encodedPassword)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is not valid!");
        }
    }
}