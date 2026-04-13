import java.util.HashMap;
import java.util.Map;

public class java_31416_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_31416_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}