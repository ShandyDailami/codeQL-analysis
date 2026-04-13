import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21395_CredentialValidator_A08 {
    private Map<String, String> users;

    public java_21395_CredentialValidator_A08() {
        this.users = new HashMap<>();
        users.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        users.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
        // Add more users as needed
    }

    public boolean validateCredentials(String username, String password) {
        byte[] decodedBytes = Base64.getDecoder().decode(users.get(username));
        String decodedPassword = new String(decodedBytes);
        return decodedPassword.equals(password);
    }
}