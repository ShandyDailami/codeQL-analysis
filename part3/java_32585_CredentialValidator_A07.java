import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32585_CredentialValidator_A07 {

    private Map<String, String> credentials;

    public java_32585_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String user, String password) {
        this.credentials.put(user, encodePassword(password));
    }

    public boolean validateCredential(String user, String password) {
        String encodedPassword = this.credentials.get(user);
        if (encodedPassword != null) {
            return decodePassword(encodedPassword).equals(encodePassword(password));
        } else {
            return false;
        }
    }

    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private String decodePassword(String encodedPassword) {
        return new String(Base64.getDecoder().decode(encodedPassword));
    }
}