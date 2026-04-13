import java.util.HashMap;
import java.util.Map;

public class java_35512_CredentialValidator_A01 {
    private Map<String, String> userDatabase;

    public java_35512_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password"); // This is a fake database, replace it with your actual database.
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username)) {
            return userDatabase.get(username).equals(password);
        } else {
            return false;
        }
    }
}