import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36494_CredentialValidator_A01 {

    private Map<String, String> userDatabase;

    public java_36494_CredentialValidator_A01() {
        userDatabase = new HashMap<>();
        userDatabase.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (userDatabase.containsKey(username)) {
            String expectedPassword = userDatabase.get(username);
            return expectedPassword.equals(password);
        } else {
            return false;
        }
    }
}