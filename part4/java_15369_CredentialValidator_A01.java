import java.util.Arrays;
import java.util.List;

public class java_15369_CredentialValidator_A01 {
    private List<String> knownUsernames = Arrays.asList("admin", "user1", "user2");
    private List<String> knownPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        if (knownUsernames.contains(username) && knownPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password1";

        if (validator.validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}