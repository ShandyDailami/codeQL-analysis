import java.util.HashMap;
import java.util.Map;

public class java_16823_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_16823_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String username, String password) {
        if(credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if(validator.validate("wrongUser", "wrongPassword")) {
            System.out.println("Authentication failed");
        } else {
            System.out.println("Authentication successful");
        }
    }
}