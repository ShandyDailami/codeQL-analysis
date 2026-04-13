import java.util.HashMap;
import java.util.Map;

public class java_30718_CredentialValidator_A01 {

    // Pre-defined list of usernames and passwords
    private Map<String, String> usernamesAndPasswords;

    // Constructor
    public java_30718_CredentialValidator_A01() {
        this.usernamesAndPasswords = new HashMap<>();
        usernamesAndPasswords.put("admin", "password");
        usernamesAndPasswords.put("user1", "password1");
        usernamesAndPasswords.put("user2", "password2");
    }

    // Credential Validator method
    public boolean validate(String username, String password) {
        if (usernamesAndPasswords.containsKey(username) && 
            usernamesAndPasswords.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}