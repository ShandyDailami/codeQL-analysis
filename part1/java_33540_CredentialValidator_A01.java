import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class java_33540_CredentialValidator_A01 {

    private static final Set<String> ALLOWED_ROLES = new HashSet<>(Arrays.asList("ROLE_ADMIN", "ROLE_USER", "ROLE_GUEST"));

    public boolean validate(String username, String password) {
        // You should not store passwords in plain text. 
        // Use secure hashing methods for real-world applications.
        // Here we are only storing them for the sake of the example.
        String hashedPassword = hashPassword(password);

        // In a real-world application, you would have a database
        // to fetch user roles from. Here we just check if the username is in the list of allowed roles.
        Set<String> roles = getUserRoles(username);

        return ALLOWED_ROLES.containsAll(roles) && roles.containsAll(ALLOWED_ROLES);
    }

    private Set<String> getUserRoles(String username) {
        // Implement a method to fetch user roles from a database or a user service.
        // Here we are only fetching a hardcoded set of roles.
        return new HashSet<>(Arrays.asList("ROLE_ADMIN", "ROLE_USER"));
    }

    private String hashPassword(String password) {
        // Implement a method to hash passwords using a secure hashing method.
        // Here we are only hashing a hardcoded password.
        return Base64.getEncoder().encodeToString(password.getBytes());
    }
}