import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00879_CredentialValidator_A01 {
    private static Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
        users.put("user", Base64.getEncoder().encodeToString("user:user".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String storedPassword = users.get(username);

        return storedPassword != null && storedPassword.equals(encodedPassword);
    }
}