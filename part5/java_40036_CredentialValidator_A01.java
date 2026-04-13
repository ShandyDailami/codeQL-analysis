import java.util.ArrayList;
import java.util.List;

public class java_40036_CredentialValidator_A01 {
    // Create a list of usernames and passwords
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();

    // Constructor to populate the lists
    public java_40036_CredentialValidator_A01() {
        usernames.add("user1");
        usernames.add("user2");
        usernames.add("user3");

        passwords.add("password1");
        passwords.add("password2");
        passwords.add("password3");
    }

    // CredentialValidator interface method
    public boolean validate(String username, String password) {
        // Check if the username and password are valid
        if (usernames.contains(username) && passwords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}