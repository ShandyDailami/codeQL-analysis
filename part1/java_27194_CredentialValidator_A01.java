import java.util.HashMap;
import java.util.Map;

public class java_27194_CredentialValidator_A01 {
    // In-Memory UserStore
    private Map<String, String> userStore;

    public java_27194_CredentialValidator_A01() {
        userStore = new HashMap<>();
        userStore.put("user1", "password1");
        userStore.put("user2", "password2");
        userStore.put("user3", "password3");
    }

    // Attempts to validate the provided username and password
    // Returns true if the credentials are valid, false otherwise
    public boolean validateCredentials(String username, String password) {
        if (userStore.containsKey(username) && userStore.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}