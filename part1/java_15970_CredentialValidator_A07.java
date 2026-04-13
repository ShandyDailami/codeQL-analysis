import java.util.Arrays;
import java.util.List;

public class java_15970_CredentialValidator_A07 {
    private static final List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private static final List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        int index = validUsers.indexOf(username);
        if (index == -1) {
            return false;
        }

        return validPasswords.get(index).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // prints true
        System.out.println(validator.validate("user4", "password1")); // prints false
    }
}