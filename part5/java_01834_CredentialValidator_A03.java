import java.util.HashMap;
import java.util.Map;

public class java_01834_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_01834_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password1")); // Should print true
        System.out.println(validator.validate("user3", "password3")); // Should print false
    }
}