import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_19808_CredentialValidator_A07 {

    private Map<String, String> credentialStorage;

    public java_19808_CredentialValidator_A07() {
        this.credentialStorage = new HashMap<>();
    }

    public void addCredentials(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentialStorage.put(username, encodedPassword);
    }

    public boolean validateCredentials(String username, String password) {
        if (!this.credentialStorage.containsKey(username)) {
            System.out.println("Invalid username");
            return false;
        }

        String expectedPassword = this.credentialStorage.get(username);
        byte[] expectedBytes = Base64.getDecoder().decode(expectedPassword);
        byte[] givenBytes = Base64.getDecoder().decode(password);
        String givenPassword = new String(givenBytes);

        if (!givenPassword.equals(expectedPassword)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Credentials validated successfully for user: " + username);
        return true;
    }
}