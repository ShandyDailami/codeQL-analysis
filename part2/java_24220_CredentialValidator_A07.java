import java.util.HashMap;
import java.util.Map;

public class java_24220_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_24220_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);

        if (expectedPassword == null) {
            System.out.println("Unknown username. Authentication failed.");
            return false;
        }

        if (!expectedPassword.equals(password)) {
            System.out.println("Wrong password. Authentication failed.");
            return false;
        }

        System.out.println("Authentication successful.");
        return true;
    }
}