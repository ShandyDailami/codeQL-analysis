import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_11199_CredentialValidator_A03 {

    // Hash the password
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes());
        return new String(hash);
    }

    // Generate random salt
    public static String generateSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return new String(salt);
    }

    // Validate the password
    public static boolean validatePassword(String userPassword, String storedPassword, String storedSalt) throws NoSuchAlgorithmException {
        String hashedInputPassword;
        String hashedInputSalt;

        // Hash the user's password and the stored salt
        try {
            hashedInputPassword = hashPassword(userPassword);
            hashedInputSalt = hashPassword(storedSalt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        }

        // Check if the hashed input password and the stored hashed password match
        return hashedInputPassword.equals(storedPassword);
    }

    public static void main(String[] args) {
        String userPassword = "userpassword"; // user's password
        String storedPassword; // hashed password
        String storedSalt; // hashed salt

        // Store the user's password and salt in the database
        try {
            storedPassword = hashPassword(userPassword);
            storedSalt = generateSalt();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }

        // Validate the password
        try {
            boolean isValid = validatePassword(userPassword, storedPassword, storedSalt);
            System.out.println(isValid ? "Valid password" : "Invalid password");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return;
        }
    }
}