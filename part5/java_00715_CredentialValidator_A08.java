import java.util.Arrays;
import java.util.List;

public class java_00715_CredentialValidator_A08 {

    private List<String> allowedUsers = Arrays.asList("user1", "user2", "user3");
    private List<String> allowedPasswords = Arrays.asList("pass1", "pass2", "pass3");

    public boolean validate(String username, String password) {
        if (allowedUsers.contains(username) && allowedPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}