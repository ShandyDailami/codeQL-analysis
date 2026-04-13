import java.util.HashSet;
import java.util.Set;

public class java_16951_CredentialValidator_A01 {

    // A set of usernames and passwords.
    private Set<String> validUsers;

    // Construct a new validator.
    public java_16951_CredentialValidator_A01() {
        validUsers = new HashSet<String>();
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    // Method that validates the provided username and password.
    public boolean isValid(String username, String password) {
        // Check if the username is in the set of valid users.
        if (validUsers.contains(username)) {
            // Check if the password matches the username.
            // In a real-world application, you'd likely want to hash and salt the password
            // before comparing it to the database.
            return password.equals("password");
        } else {
            return false;
        }
    }
}