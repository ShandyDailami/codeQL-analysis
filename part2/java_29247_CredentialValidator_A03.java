import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class java_29247_CredentialValidator_A03 {
    public static boolean validatePassword(String password) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeySpecException {
        // Check if the password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if the password has a length less than 8
        if (password.length() < 8) {
            return false;
        }

        // Check if the password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Check if the password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // Check if the password contains a lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        // Check if the password contains a uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // If the password passed all checks, return true
        return true;
    }

    public static void main(String[] args) {
        try {
            String password = "Str0ngP455w0rd!";
            if (validatePassword(password)) {
                System.out.println("Password is valid.");
            } else {
                System.out.println("Password is not valid.");
            }
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}