import java.util.Map;
import java.util.HashMap;
import java.util.Base64;

public class java_14548_CredentialValidator_A01 {

    // Map of allowed usernames and passwords
    private Map<String, String> credentials;

    public java_14548_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Add some default credentials
        this.credentials.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validate(String username, String password) {
        // In a real application, passwords would never be stored in plain text, 
        // and would typically be hashed and salted. 
        // This is just for demonstration purposes.
        return this.credentials.containsKey(username) 
            && this.credentials.get(username).equals(password);
    }
}