import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_24871_CredentialValidator_A07 {
    private Map<String, String> credentials;

    public java_24871_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String user, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(user, encodedPassword);
    }

    public boolean validateCredential(String user, String password) {
        String encodedPassword = this.credentials.get(user);
        if (encodedPassword == null) {
            return false;
        }
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPassword);
        String decodedPassword = new String(decodedBytes);
        return password.equals(decodedPassword);
    }
}