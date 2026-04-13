import java.util.Arrays;
import java.util.List;

public class java_04594_CredentialValidator_A03 {

    // Static list of usernames and passwords.
    private static final List<User> users = Arrays.asList(
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
    );

    // User class for simple data transfer.
    private static class User {
        private String username;
        private String password;

        public java_04594_CredentialValidator_A03(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters.
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // Validate method.
    public static boolean validate(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}