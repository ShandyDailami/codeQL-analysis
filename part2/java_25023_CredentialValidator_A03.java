import java.util.HashMap;
import java.util.Map;

public class java_25023_CredentialValidator_A03 {
    private Map<String, String> credentials;

    public java_25023_CredentialValidator_A03() {
        // This could be replaced with a database or other persistent storage method
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validateCredentials(String username, String password) {
        // This is a very simplistic way of checking credentials, in a real-world scenario you'd want to use a more secure method of checking passwords.
        String expectedPassword = this.credentials.get(username);
        return password.equals(expectedPassword);
    }
}