import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.HashMap;

public class java_22597_CredentialValidator_A07 {
    private HashMap<String, String> credentialStore;

    public java_22597_CredentialValidator_A07() {
        this.credentialStore = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }
        this.credentialStore.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }
        String storedPassword = this.credentialStore.get(username);
        if (storedPassword == null) {
            return false;
        }
        byte[] storedPasswordBytes = storedPassword.getBytes();
        byte[] suppliedPasswordBytes = password.getBytes();
        return Arrays.equals(suppliedPasswordBytes, storedPasswordBytes);
    }
}