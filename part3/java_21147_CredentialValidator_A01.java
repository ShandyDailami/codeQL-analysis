import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21147_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_21147_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username)) {
            String storedPassword = this.credentials.get(username);
            return storedPassword.equals(Base64.getEncoder().encodeToString(password.getBytes()));
        } else {
            return false;
        }
    }

}