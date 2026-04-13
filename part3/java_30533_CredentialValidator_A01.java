import java.util.ArrayList;
import java.util.List;

public class java_30533_CredentialValidator_A01 {

    private static final List<String> VALID_USERNAMES = new ArrayList<>();
    private static final List<String> VALID_PASSWORDS = new ArrayList<>();

    static {
        VALID_USERNAMES.add("admin");
        VALID_USERNAMES.add("user");
        VALID_PASSWORDS.add("password");
        VALID_PASSWORDS.add("admin");
    }

    public boolean validate(String username, String password) {
        // Break access control by only allowing certain usernames
        if ("admin".equals(username)) {
            return isValidPassword(password);
        }

        // If not an admin, allow all usernames
        return isValidUsername(username);
    }

    private boolean isValidUsername(String username) {
        return VALID_USERNAMES.contains(username);
    }

    private boolean isValidPassword(String password) {
        return VALID_PASSWORDS.contains(password);
    }
}