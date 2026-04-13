import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.util.logging.Logger;

public class java_32949_CredentialValidator_A01 {
    
    private static final Logger logger = Logger.getLogger(CredentialValidator.class.getName());

    public boolean validateCredentials(String username, String password, String hashedPassword) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPasswordVerify = sb.toString();
            return hashedPasswordVerify.equals(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            logger.severe("No such algorithm: SHA-256");
        } catch (Exception e) {
            logger.severe("Error during password hashing: " + e.getMessage());
        }
        return false;
    }
}