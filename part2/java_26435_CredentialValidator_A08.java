// User Class
public class java_26435_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_26435_CredentialValidator_A08(String username, String password) {
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

// CredentialValidator Class
public class CredentialValidator {
    private User user;

    public java_26435_CredentialValidator_A08() {
        user = new User("admin", "password"); // this should be in a real-world application
    }

    public boolean validatePassword(String password) {
        // Simulating a real-world password validation by checking if the password matches the expected password
        return password.equals(user.getPassword());
    }
}