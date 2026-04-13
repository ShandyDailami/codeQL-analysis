import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_20959_CredentialValidator_A07 {
    public String username;
    public String password;

    public java_20959_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class CredentialValidator {
    private Map<String, String> users = new HashMap<>();

    public java_20959_CredentialValidator_A07() {
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes())); // replace with your own encryption
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes())); // replace with your own encryption
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return users.get(username).equals(encodedPassword);
    }
}