import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32714_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_32714_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        String correctPassword = this.credentials.get(user);
        if (correctPassword == null) {
            return false;
        }

        String correctPasswordBase64 = new String(Base64.getEncoder().encode(correctPassword.getBytes()));
        String providedPasswordBase64 = new String(Base64.getEncoder().encode(password.getBytes()));

        return correctPasswordBase64.equals(providedPasswordBase64);
    }
}