import java.util.HashMap;
import java.util.Map;

public class java_15751_CredentialValidator_A03 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        credentials.put("admin", "password");
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    public static boolean validateCredentials(String username, String password) {
        return credentials.get(username) != null && credentials.get(username).equals(password);
    }

}