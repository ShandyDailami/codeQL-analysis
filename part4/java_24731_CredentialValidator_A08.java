import java.util.HashMap;
import java.util.Map;

public class java_24731_CredentialValidator_A08 {
    private Map<String, String> userDatabase;

    public java_24731_CredentialValidator_A08() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", "password");
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = userDatabase.get(username);

        // A08_IntegrityFailure: Do not use insecure passwords
        if (expectedPassword == null || !expectedPassword.equals(password)) {
            return false;
        }

        return true;
    }
}