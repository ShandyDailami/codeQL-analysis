import java.util.Arrays;
import java.util.List;

public class java_35839_CredentialValidator_A08 {
    private List<String> validUsers = Arrays.asList("user1", "user2", "user3");
    private List<String> validPasswords = Arrays.asList("password1", "password2", "password3");

    public boolean validate(String username, String password) {
        if (!validUsers.contains(username)) {
            System.out.println("Invalid username");
            return false;
        }
        if (!validPasswords.contains(password)) {
            System.out.println("Invalid password");
            return false;
        }
        System.out.println("Successfully validated!");
        return true;
    }
}