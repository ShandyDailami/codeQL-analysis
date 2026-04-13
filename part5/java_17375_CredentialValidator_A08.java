import java.util.HashMap;
import java.util.Map;

public class java_17375_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_17375_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}