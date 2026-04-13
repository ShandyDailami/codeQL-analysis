import java.util.HashMap;
import java.util.Map;

public class java_27506_CredentialValidator_A08 {

    private Map<String, String> userCredentials;

    public java_27506_CredentialValidator_A08() {
        userCredentials = new HashMap<>();
        // Add some example user credentials
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if(userCredentials.containsKey(user) && userCredentials.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}