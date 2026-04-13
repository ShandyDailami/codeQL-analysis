public class java_35988_CredentialValidator_A08 {

    // Method to check if password matches with user data
    public boolean validatePassword(String enteredPassword, String userPassword) {
        // Compare the entered and stored passwords
        if (enteredPassword.equals(userPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if username matches with user data
    public boolean validateUsername(String enteredUsername, String userUsername) {
        // Compare the entered and stored usernames
        if (enteredUsername.equals(userUsername)) {
            return true;
        } else {
            return false;
        }
    }

    // Method to check if user is authenticated
    public boolean isAuthenticated(boolean userIsAuthenticated) {
        // If user is authenticated, return true
        if (userIsAuthenticated) {
            return true;
        } else {
            // Else, throw an exception
            throw new SecurityException("User is not authenticated");
        }
    }

    // Method to check if user is authorized
    public boolean isAuthorized(boolean userIsAuthorized, String userRole) {
        // If user is authorized, return true
        if (userIsAuthorized) {
            return true;
        } else {
            // Else, throw an exception
            throw new SecurityException("User is not authorized");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        // Testing
        System.out.println(validator.validatePassword("password", "password")); // true
        System.out.println(validator.validateUsername("username", "username")); // true
        System.out.println(validator.isAuthenticated(true)); // true
        System.out.println(validator.isAuthorized(true, "admin")); // true
    }
}