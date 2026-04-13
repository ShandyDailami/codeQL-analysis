import java.util.HashMap;
import java.util.Map;

public class java_20858_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_20858_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean isValid = validator.validateCredentials("user1", "password1");

        if(isValid) {
            System.out.println("Validated successfully!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}