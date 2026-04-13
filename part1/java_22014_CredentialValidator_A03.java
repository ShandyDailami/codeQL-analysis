import java.util.HashMap;
import java.util.Map;

public class java_22014_CredentialValidator_A03 {

    private Map<String, String> userCredentials;

    public java_22014_CredentialValidator_A03() {
        this.userCredentials = new HashMap<>();
        this.userCredentials.put("user1", "password1");
        this.userCredentials.put("user2", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        if (userCredentials.containsKey(user)) {
            return userCredentials.get(user).equals(password);
        } else {
            return false;
        }
    }

}