import java.util.Base64;
import java.util.HashMap;

public class java_02524_CredentialValidator_A07 {

    // Map to store credentials
    private HashMap<String, String> credentials;

    public java_02524_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    // Method to add a new credential
    public void addCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        this.credentials.put(username, encryptedPassword);
    }

    // Method to validate a credential
    public boolean validateCredential(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return this.credentials.containsKey(username) && this.credentials.get(username).equals(encryptedPassword);
    }

    // Method to encrypt password
    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    // Method to decrypt password
    private String decryptPassword(String encryptedPassword) {
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        return new String(decodedBytes);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        validator.addCredential("alice", "password1");
        validator.addCredential("bob", "password2");

        System.out.println(validator.validateCredential("alice", "password1")); // Expected output: true
        System.out.println(validator.validateCredential("bob", "password2")); // Expected output: true
        System.out.println(validator.validateCredential("alice", "wrongpassword")); // Expected output: false
    }
}