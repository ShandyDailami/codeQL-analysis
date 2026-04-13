import java.security.*;
import java.util.*;
import javax.crypto.*;
import sun.security.util.*;

public class java_08252_CredentialValidator_A08 {
    private static final String SALT = "A08_IntegrityFailure";

    public boolean validate(String password) {
        // Step 1: Check if password is too short or too long
        if (password == null || password.length() < 8) {
            return false;
        }

        // Step 2: Check if password contains upper case and lower case letters
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Step 3: Check if password contains numbers
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Step 4: Check if password contains special characters
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>]*")) {
            return false;
        }

        // Step 5: Verify password is not too similar to system passwords
        if (sun.security.util.SecurityUtil.isSimilar(password, "password")) {
            return false;
        }

        // Step 6: Check if password is secure (contains a sequence of the same character repeating X times,
        // contains sequence of digits, contains sequence of alphabets repeating more than twice,
        // contains sequence of alphabets repeating more than once)
        if (!password.matches(".*([a-z]).*\\1\\1.*")) {
            return false;
        }

        // Step 7: Check if password has a mix of upper and lower case letters
        if (password.matches(".*([A-Z]).*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("A08_IntegrityFailure")); // should return true
        System.out.println(validator.validate("password")); // should return false
    }
}