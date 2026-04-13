import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_28068_CredentialValidator_A01 {
    public static boolean validate(String user, String password) {
        if (user == null || password == null)
            throw new InvalidParameterException("User or Password is null");

        String hashedPassword = hashPassword(password);

        // Assume that a real database connection is already established
        // Here you would fetch the user's password from the database
        // This is a simplification and doesn't actually check the password
        if (!hashedPassword.equals(getPasswordFromDB(user)))
            return false;

        return true;
    }

    private static String hashPassword(String password) {
        if (password == null)
            throw new InvalidParameterException("Password is null");

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    // This method is a simplification and doesn't actually fetch the password
    private static String getPasswordFromDB(String user) {
        // You would replace this with a real method that fetches the user's password from the database
        return "hashedpassword";
    }
}