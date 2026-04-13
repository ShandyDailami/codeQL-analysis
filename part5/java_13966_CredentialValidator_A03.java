import java.util.HashMap;
import java.util.Map;

public class java_13966_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_13966_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}