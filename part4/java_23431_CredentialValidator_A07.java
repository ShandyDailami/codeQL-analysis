import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_23431_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_23431_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        this.credentials.put(username, encryptedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return this.credentials.get(username).equals(encryptedPassword);
    }

    private String encryptPassword(String password) {
        byte[] plainText = password.getBytes();
        byte[] encryptedPassword = Base64.getEncoder().encode(plainText);
        return new String(encryptedPassword);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.addCredential("user1", "password1");
        validator.addCredential("user2", "password2");

        boolean isValid1 = validator.validateCredentials("user1", "password1"); // true
        boolean isValid2 = validator.validateCredentials("user2", "password2"); // true
        boolean isValid3 = validator.validateCredentials("user1", "wrongPassword"); // false

        System.out.println("Is valid user1? " + isValid1); // true
        System.out.println("Is valid user2? " + isValid2); // true
        System.out.println("Is valid user1? " + isValid3); // false
    }
}