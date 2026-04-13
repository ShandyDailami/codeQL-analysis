import java.util.HashMap;
import java.util.Map;

public class java_18491_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_18491_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.validateCredentials("user1", "password1")); // Returns true
        System.out.println(validator.validateCredentials("user2", "wrongPassword")); // Returns false
        System.out.println(validator.validateCredentials("unknownUser", "password")); // Returns false
    }
}