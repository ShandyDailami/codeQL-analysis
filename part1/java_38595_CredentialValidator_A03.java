import java.util.HashMap;
import java.util.Map;

public class java_38595_CredentialValidator_A03 {

    private static final Map<String, String> VALID_CREDENTIALS = new HashMap<>();

    static {
        VALID_CREDENTIALS.put("user1", "password1");
        VALID_CREDENTIALS.put("user2", "password2");
        VALID_CREDENTIALS.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = VALID_CREDENTIALS.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

}