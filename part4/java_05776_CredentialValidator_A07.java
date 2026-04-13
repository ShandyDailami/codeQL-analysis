import java.util.HashMap;
import java.util.Map;

public class java_05776_CredentialValidator_A07 {

    // A map of valid usernames and passwords.
    private Map<String, String> validUsers;

    public java_05776_CredentialValidator_A07() {
        validUsers = new HashMap<>();
        validUsers.put("user1", "password1");
        validUsers.put("user2", "password2");
        validUsers.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        // Return true if the credentials are valid, false otherwise.
        return validUsers.containsKey(username) && validUsers.get(username).equals(password);
    }
}