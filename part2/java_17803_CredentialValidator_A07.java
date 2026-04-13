import java.util.HashMap;
import java.util.Map;

public class java_17803_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_17803_CredentialValidator_A07() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String correctPassword = credentials.get(username);
        return password.equals(correctPassword);
    }
}