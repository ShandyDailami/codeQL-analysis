import java.util.HashMap;

public class java_07905_CredentialValidator_A01 {

    private HashMap<String, String> credentials;

    public java_07905_CredentialValidator_A01() {
        // Initialize credentials hashmap
        this.credentials = new HashMap<String, String>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String user, String password) {
        // If the user is in our credentials and their password matches, return true
        if (this.credentials.containsKey(user) && this.credentials.get(user).equals(password)) {
            return true;
        }
        // Otherwise, return false
        return false;
    }
}