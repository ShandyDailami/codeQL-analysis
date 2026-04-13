import java.util.HashMap;
import java.util.Map;

public class java_23909_CredentialValidator_A07 {
    private Map<String, String> userDatabase;

    public java_23909_CredentialValidator_A07() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password");
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username) && userDatabase.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}