import java.security.Provider;
import java.security.Security;
import java.security.MessageDigest;
import java.security.InvalidParameterException;

public class java_35343_CredentialValidator_A03 {
    public static void main(String[] args) {
        // Get the provider for the MessageDigest
        Provider provider = Security.getProvider("SUN");
        if (provider == null) {
            System.err.println("SunJCE provider is not available.");
            System.exit(1);
        }

        // Create a MessageDigest instance for the SHA-256 algorithm
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Check if the password contains the word "password"
            if (checkPassword(md, "password")) {
                System.out.println("The password contains the word 'password'.");
            } else {
                System.out.println("The password does not contain the word 'password'.");
            }
        } catch (Exception e) {
            System.err.println("Failed to create MessageDigest instance: " + e.getMessage());
            System.exit(1);
        }
    }

    private static boolean checkPassword(MessageDigest md, String password) {
        // Hash the password
        byte[] hash = md.digest(password.getBytes());

        // Check if the password contains the word "password"
        // This is a very simplistic check. In a real-world application, you would likely
        // use a more complex method of checking the password, such as a hash or a password
        // hash.
        return new String(hash).contains("password");
    }
}