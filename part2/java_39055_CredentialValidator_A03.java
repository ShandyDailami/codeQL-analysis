import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_39055_CredentialValidator_A03 {

    private Map<String, String> credentials = new HashMap<>();

    public java_39055_CredentialValidator_A03() {
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && encodedPassword.equals(credentials.get(username));
    }
}