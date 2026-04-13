import java.util.Arrays;
import java.util.List;

public class java_28090_CredentialValidator_A03 {
    private static final List<String> ALLOWED_USERS = Arrays.asList("user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        if (ALLOWED_USERS.contains(username) && ALLOWED_PASSWORDS.contains(password)) {
            return true;
        } else {
            return false;
        }
    }

    // You can also add a main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user4", "password4")); // false
    }
}