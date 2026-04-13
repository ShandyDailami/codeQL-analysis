import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class java_09521_CredentialValidator_A03 {

    private final Set<String> allowedUsers = new HashSet<>(Arrays.asList("user1", "user2", "user3"));
    private final Set<String> allowedPasswords = new HashSet<>(Arrays.asList("password1", "password2", "password3"));

    public boolean validate(String user, String password) {
        return allowedUsers.contains(user) && allowedPasswords.contains(encryptPassword(password));
    }

    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // should print true
        System.out.println(validator.validate("user1", "password4")); // should print false
    }
}