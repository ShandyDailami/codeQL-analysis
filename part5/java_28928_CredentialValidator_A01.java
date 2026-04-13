import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_28928_CredentialValidator_A01 {

    private static final Map<String, String> credentials = new HashMap<>();

    static {
        // Here we would typically store these credentials in a database,
        // but for this example, we'll just use a map.
        credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean isValidCredential(String username, String password) {
        String expectedPassword = credentials.get(username);
        return expectedPassword != null && expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
    }
}