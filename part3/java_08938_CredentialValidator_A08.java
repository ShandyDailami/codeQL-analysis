public class java_08938_CredentialValidator_A08 {
    private String username;
    private String password;

    // Constructor
    public java_08938_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class CredentialValidator {
    public boolean isValid(String username, String password) {
        // In a real-world application, this would be done in a secure way,
        // such as by hashing the password and comparing it to a stored hash.
        // For now, we'll just check if the provided username and password match the hard-coded ones.
        User user = new User(username, password);
        if (user.getUsername().equals("admin") && user.getPassword().equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}