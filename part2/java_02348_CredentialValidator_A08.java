import java.util.Arrays;
import java.util.List;

public class java_02348_CredentialValidator_A08 {
    // A list of expected usernames and passwords.
    private static final List<String> expectedUsers = Arrays.asList("user1", "user2", "user3");
    private static final List<String> expectedPasswords = Arrays.asList("password1", "password2", "password3");

    public static boolean validateCredentials(String username, String password) {
        // Check if the username and password match an expected username and password.
        int index = expectedUsers.indexOf(username);
        if (index != -1) {
            return expectedPasswords.get(index).equals(password);
        }

        // If the username does not match an expected username, return false.
        return false;
    }
}