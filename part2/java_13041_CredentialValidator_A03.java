import java.util.HashMap;
import java.util.Map;

public class java_13041_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_13041_CredentialValidator_A03() {
        // Hardcoded credentials. You should ideally fetch this from a secure source.
        credentials = new HashMap<String, String>();
        credentials.put("admin", "password");
        credentials.put("user", "userpassword");
    }

    public boolean validate(String username, String password) {
        // Check if the provided username and password matches the stored credentials.
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}