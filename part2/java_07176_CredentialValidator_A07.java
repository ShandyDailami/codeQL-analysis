public class java_07176_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_07176_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isValidPassword(String password) {
        // We'll just check if the provided password is equal to our stored password
        return this.password.equals(password);
    }
}

public class CredentialValidator {
    private User[] users;

    public java_07176_CredentialValidator_A07() {
        // We'll create some users for testing
        users = new User[] {
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
        };
    }

    public boolean validateCredentials(String username, String password) {
        // Loop through all the users
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                // Check if the provided password matches the stored password
                if (user.isValidPassword(password)) {
                    return true;
                }
            }
        }
        // If we got here, the credentials were not found
        return false;
    }
}