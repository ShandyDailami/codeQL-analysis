import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_18390_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_18390_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (!credentials.containsKey(username)) {
            throw new InvalidParameterException("Invalid username");
        }
        
        String storedPassword = credentials.get(username);
        String storedPasswordDecoded = new String(Base64.getDecoder().decode(storedPassword));
        
        if (!storedPasswordDecoded.equals(password)) {
            throw new InvalidParameterException("Invalid password");
        }

        return true;
    }
}