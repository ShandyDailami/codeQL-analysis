import java.util.HashMap;
import java.util.Map;

public class java_30050_CredentialValidator_A03 {

    // Pre-defined set of hard-coded credentials
    private static final Map<String, String> hardCodedCredentials = new HashMap<String, String>() {{
        put("user1", "password1");
        put("user2", "password2");
        put("user3", "password3");
    }};

    // Credential validator method
    public boolean validate(String username, String password) {
        // Check if the credentials match the hard-coded set
        if (hardCodedCredentials.containsKey(username) &&
                hardCodedCredentials.get(username).equals(password)) {
            return true;
        }

        return false;
    }
}