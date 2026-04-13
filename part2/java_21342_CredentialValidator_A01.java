import java.util.Base64;

public class java_21342_CredentialValidator_A01 {
    private User user;

    public java_21342_CredentialValidator_A01(User user) {
        this.user = user;
    }

    public boolean validate(String username, String password) {
        // Convert the provided password to Base64 for comparison
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Compare the provided password with the password in the user object
        return user.getUsername().equals(username) && user.getPassword().equals(encodedPassword);
    }
}

public class User {
    private String username;
    private String password;

    public java_21342_CredentialValidator_A01(String username, String password) {
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