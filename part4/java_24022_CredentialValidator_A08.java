import java.util.HashMap;
import java.util.Map;

public class java_24022_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_24022_CredentialValidator_A08() {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user4", "password4")); // false
    }
}