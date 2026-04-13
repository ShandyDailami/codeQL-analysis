import java.util.HashMap;
import java.util.Map;

public class java_23434_CredentialValidator_A01 {
    // known users
    private Map<String, String> knownUsers;

    public java_23434_CredentialValidator_A01() {
        knownUsers = new HashMap<>();
        knownUsers.put("user1", "password1");
        knownUsers.put("user2", "password2");
        knownUsers.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // check if username and password match known users
        return knownUsers.get(username) != null && knownUsers.get(username).equals(password);
    }
}