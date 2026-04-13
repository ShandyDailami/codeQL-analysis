import java.util.HashMap;
import java.util.Map;

public class java_00891_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_00891_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) && this.credentials.get(username).equals(password)) {
            System.out.println("Access granted for user: " + username);
            return true;
        } else {
            System.out.println("Access denied for user: " + username);
            return false;
        }
    }
}