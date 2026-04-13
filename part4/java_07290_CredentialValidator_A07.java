import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_07290_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_07290_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean authenticate(String user, String password) {
        if (!this.credentials.containsKey(user)) {
            return false;
        }

        String encodedPassword = this.credentials.get(user);
        String decodedPassword = new String(Base64.getDecoder().decode(encodedPassword));

        return password.equals(decodedPassword);
    }
}