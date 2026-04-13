import java.util.Arrays;
import java.util.List;

public class java_13900_CredentialValidator_A03 {
    private final List<String> validUsernames = Arrays.asList("user1", "user2", "user3");
    private final List<String> validPasswords = Arrays.asList("pass1", "pass2", "pass3");

    public boolean validateCredentials(String username, String password) {
        return validUsernames.contains(username) && validPasswords.contains(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "user1";
        String password = "pass1";

        if (validator.validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}