import java.util.Arrays;
import java.util.List;

public class java_36587_CredentialValidator_A08 {
    private List<String> allowedUsernames = Arrays.asList("user1", "user2", "user3");
    private List<String> allowedPasswords = Arrays.asList("pass1", "pass2", "pass3");

    public boolean validate(String username, String password) {
        if (allowedUsernames.contains(username) && allowedPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String username = "user1";
        String password = "pass1";
        if (validator.validate(username, password)) {
            System.out.println("Access granted for user: " + username);
        } else {
            System.out.println("Access denied for user: " + username);
        }
    }
}