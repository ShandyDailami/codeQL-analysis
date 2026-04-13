public class java_22713_CredentialValidator_A01 {

    // Simulating a method to validate credentials
    public boolean validate(String username, String password) {
        // Simulating a real-world application where we check against a database or another external source
        // This could be more complex depending on the requirements
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class SecurityContext {

    // Simulating a method to get the current user
    public String getCurrentUser() {
        return "admin";
    }

    // Simulating a method to get the current password
    public String getCurrentPassword() {
        return "password";
    }
}

public class SecurityManager {

    // Using the CredentialValidator and SecurityContext to perform a simple check for access
    public boolean checkAccess(String username, String password) {
        SecurityContext securityContext = new SecurityContext();
        CredentialValidator credentialValidator = new CredentialValidator();

        if (credentialValidator.validate(securityContext.getCurrentUser(), securityContext.getCurrentPassword())) {
            return true;
        } else {
            return false;
        }
    }
}