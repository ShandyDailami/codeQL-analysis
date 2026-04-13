public class java_38305_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_38305_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    private User currentUser;

    public void authenticate(String username, String password) {
        // Create a new user
        currentUser = new User(username, password);
    }

    public boolean isValid() {
        // Here we are checking if the user is authenticated.
        // In real application, you should call a method to validate the user
        // against a data source (like a database or a file)
        if(currentUser != null) {
            return true;
        }
        return false;
    }

    public User getCurrentUser() {
        // This method can be used to get the current user if needed.
        return currentUser;
    }
}