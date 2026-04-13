import java.util.Arrays;
import java.util.List;

public class java_23236_CredentialValidator_A03 {
    private static final List<String> BANNED_USERNAMES = Arrays.asList("banned1", "banned2", "banned3");

    public boolean isValid(String username, String password) {
        if (BANNED_USERNAMES.contains(username)) {
            System.out.println("Banned username detected: " + username);
            return false;
        }

        // Other authentication-related checks go here...

        return true;
    }
}