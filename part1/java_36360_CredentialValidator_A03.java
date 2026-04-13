import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_36360_CredentialValidator_A03 {

    private Map<String, String> userCredentials = new HashMap<>();

    public java_36360_CredentialValidator_A03() {
        userCredentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userCredentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return userCredentials.get(username) != null && userCredentials.get(username).equals(encodedPassword);
    }
}