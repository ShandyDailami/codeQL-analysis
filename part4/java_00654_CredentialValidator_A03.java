import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_00654_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_00654_CredentialValidator_A03() {
        userCredentials = new HashMap<>();

        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        userCredentials.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean isValidCredentials(String username, String password) {
        if (userCredentials.containsKey(username)) {
            return userCredentials.get(username).equals(password);
        } else {
            return false;
        }
    }
}