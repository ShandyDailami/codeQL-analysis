import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_29430_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_29430_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", this.encodePassword("password1"));
        this.credentials.put("user2", this.encodePassword("password2"));
    }

    @Override
    public boolean validate(String username, String password) {
        String encodedPassword = this.encodePassword(password);
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(encodedPassword);
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

}