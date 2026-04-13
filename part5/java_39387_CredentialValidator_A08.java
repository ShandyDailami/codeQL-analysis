import java.util.HashMap;
import java.util.Map;

public class java_39387_CredentialValidator_A08 {

    private Map<String, String> knownUsers;

    public java_39387_CredentialValidator_A08() {
        knownUsers = new HashMap<>();
        knownUsers.put("user1", "password1");
        knownUsers.put("user2", "password2");
        knownUsers.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        return knownUsers.containsKey(username) && knownUsers.get(username).equals(password);
    }
}