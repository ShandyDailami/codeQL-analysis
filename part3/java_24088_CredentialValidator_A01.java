import java.util.Base64;
import java.util.HashMap;

public class java_24088_CredentialValidator_A01 {
    private HashMap<String, String> credentials;

    public java_24088_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", "password1");
        this.credentials.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        String encryptedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        String storedPassword = this.credentials.get(user);

        // Here, we assume that the stored password is the same as the encrypted version.
        // In a real application, you would need to compare the stored and encrypted passwords.
        return storedPassword.equals(encryptedPassword);
    }
}