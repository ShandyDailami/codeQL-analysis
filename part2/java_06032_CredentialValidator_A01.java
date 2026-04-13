import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_06032_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_06032_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            return true;
        }
        return false;
    }
}