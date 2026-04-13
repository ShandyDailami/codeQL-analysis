import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_22887_CredentialValidator_A08 {

    private Map<String, String> credentials;

    public java_22887_CredentialValidator_A08() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        credentials.put(username, encryptedPassword);
    }

    public boolean validateCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return credentials.get(username).equals(encryptedPassword);
    }

    private String encryptPassword(String password) {
        byte[] bytes = password.getBytes();
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        System.out.println(validator.validateCredential("user1", "password1")); // true
        System.out.println(validator.validateCredential("user2", "password2")); // true
        System.out.println(validator.validateCredential("user1", "wrongPassword")); // false
    }
}