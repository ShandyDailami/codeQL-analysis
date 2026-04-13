import java.util.HashMap;
import java.util.Map;

public class java_03795_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_03795_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}