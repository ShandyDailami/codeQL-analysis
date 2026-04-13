import java.util.HashMap;
import java.util.Map;

public class java_38241_CredentialValidator_A08 {

    private static Map<String, String> credentials = new HashMap<>();

    static {
        // initialize the credential data
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && 
            credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

}