import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_31265_CredentialValidator_A03 {
    // Simulating a database.
    private Map<String, String> users = new HashMap<>();

    public java_31265_CredentialValidator_A03() {
        // Add some users. In a real application, you would want to use a real method to get these users.
        users.put("alice", "password1");
        users.put("bob", "password2");
    }

    public boolean validateCredentials(String user, String password) {
        // Decoding the base64 password. In a real application, you would want to use a real method to decode these passwords.
        String decodedPassword = new String(Base64.getDecoder().decode(password));
        
        // Checking the password. In a real application, you would want to use a real method to check these passwords.
        return users.get(user).equals(decodedPassword);
    }
}