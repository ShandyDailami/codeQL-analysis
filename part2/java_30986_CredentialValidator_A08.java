import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class java_30986_CredentialValidator_A08 {

    private Map<String, String> credentialMap;

    public java_30986_CredentialValidator_A08() {
        this.credentialMap = new HashMap<>();
        initializeCredentials();
    }

    private void initializeCredentials() {
        credentialMap.put("alice", "password123");
        credentialMap.put("bob", "password456");
        credentialMap.put("charlie", "password789");
    }

    public boolean validate(String username, String password) {
        String passwordInDatabase = credentialMap.get(username);
        return password.equals(passwordInDatabase);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        boolean isValid = validator.validate("alice", "password123");
        System.out.println("Is Alice's credentials valid? " + isValid);

        isValid = validator.validate("bob", "wrongPassword");
        System.out.println("Is Bob's credentials valid? " + isValid);

        isValid = validator.validate("charlie", "password789");
        System.out.println("Is Charlie's credentials valid? " + isValid);
    }
}