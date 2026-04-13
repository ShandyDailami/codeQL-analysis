import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_32152_CredentialValidator_A01 {
    public static boolean isValidPassword(String password) {
        // This is a very basic password check. In a real application,
        // you would probably want to use a more complex algorithm.
        // Also, we're not actually checking the password against a database,
        // instead we're just checking if it's actually "strong enough".
        return password.length() >= 8 && containsDigit(password) && containsLowerCase(password)
                && containsUpperCase(password);
    }

    private static boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    private static boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static void main(String[] args) {
        String password = "ThisIsAWeakPassword";
        if (isValidPassword(password)) {
            System.out.println("Password is strong enough.");
        } else {
            System.out.println("Password is not strong enough.");
        }
    }
}