import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_33364_CredentialValidator_A08 {

    private Map<String, String> users;

    public java_33364_CredentialValidator_A08() {
        users = new HashMap<>();
        users.put("alice", Base64.getEncoder().encodeToString("alice:alice".getBytes()));
        users.put("bob", Base64.getEncoder().encodeToString("bob:bob".getBytes()));
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        return expectedPassword != null && expectedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
    }
}