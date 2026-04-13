import javax.security.auth.x500.X500Principal;
import java.security.Principal;

public class java_37130_CredentialValidator_A07 {
    // Define a set of known realms
    private static final String[] REALMS = new String[] {
        "LDAP://my.realm1",
        "LDAP://my.realm2",
        "my.realm3"
    };

    // Method to validate the username
    public boolean validateCredential(String username, String password) {
        // Here we are assuming that the username and password are correct.
        // In reality, you would need to implement a more complex mechanism
        // to validate the username and password.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        }
        return false;
    }

    // Method to get the X500 principal
    public Principal getX500Principal(String username) {
        try {
            return new X500Principal(username);
        } catch (Exception e) {
            return null;
        }
    }

    // Method to validate the principal
    public boolean validatePrincipal(Principal principal) {
        // Assume that if the principal is null, it's invalid
        // In reality, you would need to implement a more complex mechanism
        // to validate the principal.
        if (principal == null) {
            return false;
        }

        // Validate the principal against the known realms
        for (String realm : REALMS) {
            if (principal.getName().equals(realm)) {
                return true;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate the username and password
        boolean valid = validator.validateCredential("admin", "password");
        System.out.println("Valid: " + valid);

        // Get the X500 principal
        Principal principal = validator.getX500Principal("CN=MyUser,O=MyCompany");
        if (principal != null) {
            // Validate the principal
            valid = validator.validatePrincipal(principal);
            System.out.println("Valid: " + valid);
        }
    }
}