import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_28840_CredentialValidator_A08 {

    public boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches(".*[@#$%^&*()+=].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String password = "StrongPassword@123";
        boolean isStrongPassword = validator.isStrongPassword(password);

        System.out.println("Is Strong Password: " + isStrongPassword);
    }
}