public class java_39840_CredentialValidator_A01 {
    // This method checks if a user is authenticated
    public boolean isUserAuthenticated(String username, String password) {
        // Here, we are just simulating the authentication process
        // In a real-world scenario, we would have a more complex authentication process
        // where we would query a database or another external source for the user's password
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // This method checks if a user is authorized to access a resource
    public boolean isUserAuthorized(String username, String resource) {
        // Here, we are just simulating the authorization process
        // In a real-world scenario, we would have a more complex authorization process
        // where we would query a database or another external source for the user's roles
        if (username.equals("admin") && (resource.equals("read") || resource.equals("write"))) {
            return true;
        } else {
            return false;
        }
    }
}