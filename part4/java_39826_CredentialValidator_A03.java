import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class java_39826_CredentialValidator_A03 {

    private Set<String> validUsernames = new HashSet<>();
    private Set<String> validPasswords = new HashSet<>();

    public java_39826_CredentialValidator_A03() {
        // Add some example credentials for validation
        validUsernames.add("user1");
        validPasswords.add("password1");
        validPasswords.add("password2");
    }

    public boolean validate(String username, String password) {
        // Use a set to quickly check if a username/password combination is valid
        if (validUsernames.contains(username) && validPasswords.contains(password)) {
            // If valid, return true
            return true;
        } else {
            // If invalid, return false
            return false;
        }
    }
}