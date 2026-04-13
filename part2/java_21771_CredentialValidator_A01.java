import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_21771_CredentialValidator_A01 implements CredentialValidator {
    private Map<String, String> credentials;

    public java_21771_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        this.credentials.put(username, encodedPassword);
    }

    @Override
    public boolean validate(String username, String password) {
        String encodedPassword = this.credentials.get(username);
        if (encodedPassword == null) {
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(encodedPassword);
        String decodedPasswordString = new String(decodedPassword);
        return password.equals(decodedPasswordString);
    }
}