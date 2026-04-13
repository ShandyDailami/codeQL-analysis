import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_37768_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_37768_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user)) {
            String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
            return encryptedPassword.equals(credentials.get(user));
        } else {
            System.out.println("Invalid user");
            return false;
        }
    }
}