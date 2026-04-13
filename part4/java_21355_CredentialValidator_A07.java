import java.security.AuthPermission;
import java.security.Credential;
import java.security.Permission;
import java.util.Arrays;
import java.util.Base64;

public class java_21355_CredentialValidator_A07 implements CredentialValidator {

    // Hardcoded passwords for verification
    private final String[] hardcodedPasswords = {"admin", "user123", "secret"};

    // Method to encode hardcoded passwords for verification
    private String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    @Override
    public boolean validate(Credential credential) {
        String decodedPassword = new String(Base64.getDecoder().decode(credential.getPassword()));
        return Arrays.asList(hardcodedPasswords).contains(decodedPassword);
    }

    @Override
    public Permission getPermission() {
        return null;
    }

    @Override
    public void initialize(String name) {
        // No-op
    }
}