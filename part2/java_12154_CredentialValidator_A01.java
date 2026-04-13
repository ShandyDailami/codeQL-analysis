import java.util.HashMap;
import java.util.Map;

public class java_12154_CredentialValidator_A01 {
    private Map<String, String> credentials;

    public java_12154_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        this.credentials.put(username, password);
    }

    public boolean validateCredentials(String username, String password) {
        if (this.credentials.containsKey(username)) {
            if (this.credentials.get(username).equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        System.out.println(validator.validateCredentials("user1", "password1"));  // Expected output: true
        System.out.println(validator.validateCredentials("user3", "password3"));  // Expected output: false
        System.out.println(validator.validateCredentials("user1", "wrongpassword"));  // Expected output: false
    }
}