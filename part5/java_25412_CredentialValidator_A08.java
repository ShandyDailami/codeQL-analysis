import java.security.Security;
import java.util.Arrays;

public class java_25412_CredentialValidator_A08 {
    public static boolean isValid(String password) {
        // Check if password is not null
        if (password == null) {
            return false;
        }

        // Check if password is not too short
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains a certain set of characters
        if (!Arrays.asList(Security.getAlgorithms("password")).contains(password.getClass().getSimpleName())) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValid("superSecret123!")); // Expected: true
        System.out.println(isValid("superSecret")); // Expected: false
        System.out.println(isValid("")); // Expected: false
    }
}