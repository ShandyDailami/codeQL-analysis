import java.security.Provider;
import java.security.Security;
import java.util.HashSet;
import java.util.Set;

public class java_03516_CredentialValidator_A07 {

    private Set<String> validUsers;

    public java_03516_CredentialValidator_A07() {
        // Initialize a set of valid users
        validUsers = new HashSet<>();
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    public boolean validate(String user, String password) {
        // Check if the user is in the set of valid users
        return validUsers.contains(user);
    }

    public static void main(String[] args) {
        // Create a new instance of the CredentialValidator
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        System.out.println(validator.validate("user1", "password1")); // Should print true
        System.out.println(validator.validate("user4", "password1")); // Should print false
    }
}