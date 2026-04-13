import java.util.HashMap;
import java.util.Map;

public class java_41338_CredentialValidator_A08 {

    private Map<String, String> userCredentials;

    public java_41338_CredentialValidator_A08() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
        userCredentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String expectedPassword = userCredentials.get(username);
        return password.equals(expectedPassword);
    }

}