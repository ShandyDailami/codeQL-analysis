import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28385_CredentialValidator_A08 {

    // hardcoded user and password for the purpose of example
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        users.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username) != null && users.get(username).equals(encodedPassword);
    }
}