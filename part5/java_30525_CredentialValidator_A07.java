import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.security.auth.login.FailedLoginException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_30525_CredentialValidator_A07 {

    public boolean validate(String plainTextPassword, String hashedPassword) throws FailedLoginException {
        try {
            // Assume the plain text password has been hashed using a suitable algorithm.
            byte[] hashedPasswordByte = Base64.getDecoder().decode(hashedPassword);
            byte[] plainTextPasswordByte = plainTextPassword.getBytes();

            // Use a suitable algorithm to compare the passwords.
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] thedigest = md.digest(plainTextPasswordByte);

            // If the hashed password is equal to the plain text password, return true.
            return MessageDigest.isEqual(hashedPasswordByte, thedigest);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new FailedLoginException("Failed to validate user credentials", e);
        }
    }
}