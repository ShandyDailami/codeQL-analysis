import java.util.ArrayList;
import java.util.List;

public class java_05751_CredentialValidator_A03 {
    // A list of allowed usernames and passwords
    private List<String> allowedUsernames = new ArrayList<>();
    private List<String> allowedPasswords = new ArrayList<>();

    public java_05751_CredentialValidator_A03() {
        // Initialize the allowed usernames and passwords
        allowedUsernames.add("admin");
        allowedPasswords.add("password");
    }

    // Method to add allowed usernames and passwords
    public void addAllowedUsername(String username) {
        allowedUsernames.add(username);
    }

    public void addAllowedPassword(String password) {
        allowedPasswords.add(password);
    }

    // Method to validate the credentials
    public boolean validate(String username, String password) {
        // Check if the username and password are in the allowed list
        return allowedUsernames.contains(username) && allowedPasswords.contains(password);
    }
}