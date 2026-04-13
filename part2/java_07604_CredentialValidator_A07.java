import java.util.HashMap;
import java.util.Map;

public class java_07604_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_07604_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean authenticate(String username, String password) {
        if(this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}