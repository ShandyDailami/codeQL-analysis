import java.util.HashMap;
import java.util.Map;

public class java_11983_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_11983_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean isValid(String username, String password) {
        if (this.credentials.containsKey(username) && 
            this.credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.isValid("user1", "password1")); // Should print: true
        System.out.println(validator.isValid("user4", "password1")); // Should print: false
    }
}