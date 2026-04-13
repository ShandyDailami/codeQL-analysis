import java.util.HashMap;
import java.util.Map;

public class java_19479_CredentialValidator_A01 {
    private Map<String, String> userDatabase;

    public java_19479_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        }
        return false;
    }
}