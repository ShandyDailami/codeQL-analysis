import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23051_CredentialValidator_A03 {

    private Map<String, String> credentials = new HashMap<>();

    public java_23051_CredentialValidator_A03() {
        // Initialize the credentials
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(credentials.get(username));

        // Compare the decoded password with the given password
        return "password1".equals(new String(decodedPassword));
    }
}