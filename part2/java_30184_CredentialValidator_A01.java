public class java_30184_CredentialValidator_A01 {
    // A method to check if the user is authorized to access a resource
    public boolean isAuthorizedToAccess(String user, String resource) {
        // Simulating authentication mechanism
        // If the user is authorized to access the resource, return true
        // Otherwise, return false
        if (user.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    // A method to check if the user's credentials are valid
    public boolean areCredentialsValid(String user, String password) {
        // Simulating validation mechanism
        // If the user's credentials are valid, return true
        // Otherwise, return false
        if (user.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // A method to validate the user's access rights
    public void validateAccessRights(String user) {
        // Simulating access rights validation mechanism
        // If the user is authorized to access the resource, print a message
        // Otherwise, print a message indicating access denied
        if (isAuthorizedToAccess(user, "resource")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied.");
        }
    }

    // A method to validate the user's credentials
    public void validateCredentials(String user, String password) {
        // Simulating credentials validation mechanism
        // If the user's credentials are valid, print a message
        // Otherwise, print a message indicating access denied
        if (areCredentialsValid(user, password)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Access denied.");
        }
    }
}