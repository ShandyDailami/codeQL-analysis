import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_14971_CredentialValidator_A01 {

    private Map<String, String> credentials;

    public java_14971_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", Base64.getEncoder().encodeToString("admin:admin".getBytes()));
    }

    public boolean validateCredentials(String username, String password) {
        if (!(username != null && password != null)) {
            return false;
        }
        String expectedPassword = this.credentials.get(username);
        if (expectedPassword == null) {
            return false;
        }
        byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
        byte[] providedPasswordBytes = password.getBytes();
        if (providedPasswordBytes.length != expectedPasswordBytes.length) {
            return false;
        }
        int match = 0;
        for (int i = 0; i < expectedPasswordBytes.length; i++) {
            match |= expectedPasswordBytes[i] ^ providedPasswordBytes[i];
        }
        return match == 0;
    }
}