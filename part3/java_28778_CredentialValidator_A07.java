import java.util.HashMap;
import java.util.Map;

public class java_28778_CredentialValidator_A07 {

    private Map<String, String> userCredentials;

    public java_28778_CredentialValidator_A07() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if (userCredentials.containsKey(username)
                && userCredentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}