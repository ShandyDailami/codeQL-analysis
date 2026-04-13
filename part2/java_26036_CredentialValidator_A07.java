import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_26036_CredentialValidator_A07 {

    // This method hashes a password using SHA-256 algorithm
    public String hashPassword(String password) {
        String hashedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }

    // This method checks if the password matches the hashed password in the database
    public boolean isValidPassword(String password, String hashedPassword) {
        return hashedPassword.equals(hashPassword(password));
    }
}