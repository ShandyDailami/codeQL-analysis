import java.util.Base64;
import java.util.HashMap;

public class java_21311_CredentialValidator_A01 {
    private HashMap<String, String> credentials;

    public java_21311_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        // Adding some dummy credentials
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
        this.credentials.put("user3", "password3");
    }

    public boolean validateCredentials(String username, String password) {
        String hashedPassword = hashPassword(password);
        return this.credentials.containsKey(username) && 
               this.credentials.get(username).equals(hashedPassword);
    }

    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validateCredentials("user1", "password1")); // true
        System.out.println(validator.validateCredentials("user2", "password2")); // false
        System.out.println(validator.validateCredentials("user3", "wrongPassword")); // false
    }
}