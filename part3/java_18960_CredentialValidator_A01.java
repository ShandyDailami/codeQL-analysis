import java.util.Arrays;
import java.util.List;

public class java_18960_CredentialValidator_A01 {

    // List of valid usernames and passwords
    private static final List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static final List<String> validPasswords = Arrays.asList("pass1", "pass2", "pass3");

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        int index = validUsers.indexOf(username);
        
        // Check if username is valid
        if (index == -1) {
            return false;
        }

        // Check if password is valid
        return validPasswords.get(index).equals(password);
    }
}