import java.util.HashMap;
import java.util.Map;

public class java_32432_CredentialValidator_A01 {
    // Store the credentials in a HashMap
    private Map<String, String> credentials;

    public java_32432_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", "password"); // default credentials
    }

    public boolean authenticate(String username, String password) {
        if (credentials.containsKey(username)) {
            // if the username exists in the map, check if the password matches
            if (credentials.get(username).equals(password)) {
                return true; // return true if the credentials are valid
            }
        }
        return false; // return false if the credentials are invalid
    }
}