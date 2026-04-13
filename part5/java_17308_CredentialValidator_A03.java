import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_17308_CredentialValidator_A03 {
    private String password;

    public java_17308_CredentialValidator_A03(String password) {
        this.password = password;
    }

    public boolean validate(String inputPassword) {
        try {
            // Use SHA-256 for secure password storage
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(inputPassword.getBytes("UTF-8"));

            // Convert byte array to Hexadecimal String
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Convert Hexadecimal String to Lowercase
            String passwordHash = hexString.toString().toLowerCase();

            // Check if password entered matches hashed password
            return passwordHash.equals(this.password);
        } catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}