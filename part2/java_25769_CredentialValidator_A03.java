import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_25769_CredentialValidator_A03 {
    // A set of special characters we consider as valid
    private static final Set<Character> VALID_CHARACTERS = new HashSet<>(Arrays.asList('@', '$', '^', '%', '&', '*', '(', ')', '_', '+', '<', '>', '?', '~'));

    // Method to validate the username
    public boolean validateUsername(String username) {
        // Check if the username contains any of the special characters
        for (char c : username.toCharArray()) {
            if (VALID_CHARACTERS.contains(c)) {
                // If so, return false, indicating an injection attempt
                return false;
            }
        }

        // If no injection attempts, return true
        return true;
    }
}