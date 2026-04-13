import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_25475_CredentialValidator_A01 {

    private String username;
    private String password;

    public java_25475_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        try {
            // Hash the password using SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            // Convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }

            // Compare the hash to a known good password
            String correctPassword = "A01_BrokenAccessControl";
            return hexString.toString().equals(correctPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("No such algorithm: SHA-256", e);
        }
    }
}