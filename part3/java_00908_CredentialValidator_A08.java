import java.util.Arrays;
import java.util.List;

public class java_00908_CredentialValidator_A08 {
    // Define a list of valid users
    private static final List<User> VALID_USERS = Arrays.asList(
            new User("user1", "password1"),
            new User("user2", "password2"),
            new User("user3", "password3")
    );

    // CredentialValidator class should not be instantiated
    private java_00908_CredentialValidator_A08() {}

    public static boolean validate(String username, String password) {
        for (User user : VALID_USERS) {
            if (user.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    // User class
    public static class User {
        private String username;
        private String password;

        public java_00908_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}