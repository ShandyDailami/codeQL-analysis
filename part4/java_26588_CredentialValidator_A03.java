import java.util.Base64;
import java.util.Optional;

public class java_26588_CredentialValidator_A03 {

    // A03_Injection example
    private String decodeCredential(String encodedCredential) {
        return Optional.ofNullable(encodedCredential)
                .map(Base64::decode)
                .map(String::new)
                .orElse("");
    }

    public boolean validateCredential(String encodedCredential) {
        String decodedCredential = decodeCredential(encodedCredential);
        // Realistic example, where username is set as decoded credential
        String username = decodedCredential.split(":")[0];

        // Sensitive operations related to security
        // e.g., verify if password matches the username
        return username.equals("admin");
    }
}