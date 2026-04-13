import java.util.HashMap;
import java.util.Map;

public class java_09407_CredentialValidator_A08 {
    private Map<String, String> credentials;

    public java_09407_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            System.out.println("User " + username + " does not exist");
            return false;
        }

        if (!expectedPassword.equals(password)) {
            System.out.println("Incorrect password for user " + username);
            return false;
        }

        System.out.println("User " + username + " has been authenticated successfully");
        return true;
    }
}