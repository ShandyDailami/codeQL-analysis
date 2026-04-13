import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_08905_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_08905_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        credentials.put("user3", Base64.getEncoder().encodeToString("password3".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return credentials.containsKey(username) && credentials.get(username).equals(encodedPassword);
    }
}