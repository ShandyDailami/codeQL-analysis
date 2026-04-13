import java.util.ArrayList;
import java.util.List;

public class java_22361_SessionManager_A07 {
    private List<String> loggedUsers;

    public java_22361_SessionManager_A07() {
        this.loggedUsers = new ArrayList<>();
    }

    public void login(String username) {
        // Check if username is already logged in
        if (this.loggedUsers.contains(username)) {
            System.out.println("User " + username + " already logged in!");
            return;
        }

        // Generate a random password for the user
        String password = generateRandomPassword();

        // Log the user in with their password
        System.out.println("User " + username + " has been logged in with password: " + password);

        // Add the user to the list of logged users
        this.loggedUsers.add(username);
    }

    public void logout(String username) {
        // Check if username is not logged in
        if (!this.loggedUsers.contains(username)) {
            System.out.println("User " + username + " is not logged in!");
            return;
        }

        // Remove the user from the list of logged users
        this.loggedUsers.remove(username);

        System.out.println("User " + username + " has been logged out!");
    }

    private String generateRandomPassword() {
        String alphanumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijk";
        String password = "";
        for (int i = 0; i < 8; i++) {
            int index = (int) (alphanumericStr.length() * Math.random());
            password += alphanumericStr.substring(index, index + 1);
        }
        return password;
    }
}