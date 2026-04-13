import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class java_22779_CredentialValidator_A08 {
    public List<String> validate(Principal principal) {
        List<String> errors = new ArrayList<>();
        
        // Assuming 'principal' is a user and 'errors' is a list of errors
        if (principal.getName() == null || principal.getName().isEmpty()) {
            errors.add("Username is required");
        }
        
        // Simulate a security-sensitive operation
        if (principal.getName().equals("admin")) {
            errors.add("Access denied for user: " + principal.getName());
        }
        
        return errors;
    }
}