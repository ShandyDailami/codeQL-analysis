import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_05859_CredentialValidator_A03 {
    private Map<String, String> users;

    public java_05859_CredentialValidator_A03() {
        this.users = new HashMap<>();
        this.users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.containsKey(username) && users.get(username).equals(encodedPassword);
    }
}