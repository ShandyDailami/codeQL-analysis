import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_09279_CredentialValidator_A07 {
    private Map<String, String> credentials = new HashMap<>();

    public java_09279_CredentialValidator_A07() {
        // dummy credentials for demonstration purposes
        credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validateCredentials(String user, String password) {
        if (credentials.containsKey(user)) {
            byte[] decodedBytes = Base64.getDecoder().decode(credentials.get(user));
            String decodedPassword = new String(decodedBytes);

            if (decodedPassword.equals(password)) {
                return true;
            }
        }

        return false;
    }
}