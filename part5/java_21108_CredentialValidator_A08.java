import java.util.ArrayList;
import java.util.List;

public class java_21108_CredentialValidator_A08 {

    private List<String> validUsers;

    public java_21108_CredentialValidator_A08() {
        // Initialize the list of valid users
        validUsers = new ArrayList<>();
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    public boolean validateCredentials(String username, String password) {
        // In a real-world application, we would need to hash the password and compare the hashes
        // For this example, let's just check if the username is in the list

        if (validUsers.contains(username)) {
            System.out.println("Access granted to user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}