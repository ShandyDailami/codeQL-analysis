import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_33997_CredentialValidator_A03 {

    public static boolean validateCredential(String username, String password) throws NoSuchAlgorithmException, InvalidParameterException {
        // This is a mock of a secure authentication system. In reality,
        // the password should not be stored in plain text, and the username
        // should be hashed before comparison.

        // In real life, the hashing algorithm should use a unique salt
        // for each user and the same salt for all passwords.
        // The salt should also be stored in the database.
        String mockSalt = "salt";

        // The following line is a placeholder for the actual password hashing
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(mockSalt.getBytes());
        byte[] hashedPassword = messageDigest.digest(password.getBytes());

        // Compare hashed password with stored hashed password
        if (hashedPassword.equals(mockSalt)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password.");
        }
    }
}