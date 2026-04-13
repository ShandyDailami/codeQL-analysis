import java.util.ArrayList;
import java.util.List;

public class java_08001_CredentialValidator_A07 {

    // A list of users. This is a mock. In a real scenario, this should be loaded from a database or other source.
    private static List<User> userList = new ArrayList<>();

    // Initialize the user list with some users.
    static {
        userList.add(new User("User1", "Password1"));
        userList.add(new User("User2", "Password2"));
        userList.add(new User("User3", "Password3"));
    }

    // CredentialValidator interface.
    public interface CredentialValidator {
        boolean validate(String username, String password);
    }

    // A simple user class.
    public static class User {
        public String username;
        public String password;

        public java_08001_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // A simple credential validator.
    public static class SimpleCredentialValidator implements CredentialValidator {
        @Override
        public boolean validate(String username, String password) {
            // In a real scenario, you should use a hash function or a secure way to compare the passwords.
            for (User user : userList) {
                if (user.username.equals(username) && user.password.equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }

    // Main method.
    public static void main(String[] args) {
        CredentialValidator validator = new SimpleCredentialValidator();

        // Assume we have a login function that takes a username and password and returns a boolean.
        boolean result = login("User1", "Password1", validator);
        System.out.println("Login result: " + result);

        result = login("User1", "WrongPassword", validator);
        System.out.println("Login result: " + result);
    }

    // Login function.
    public static boolean login(String username, String password, CredentialValidator validator) {
        return validator.validate(username, password);
    }
}