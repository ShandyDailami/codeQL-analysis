import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_11891_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_11891_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String user, String password) {
        if (this.credentials.containsKey(user)) {
            byte[] decodedBytes = Base64.getDecoder().decode(this.credentials.get(user));
            return new String(decodedBytes).equals(password);
        } else {
            return false;
        }
    }
}