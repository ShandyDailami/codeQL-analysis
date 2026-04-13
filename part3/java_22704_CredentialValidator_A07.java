import java.security.Principal;

public class java_22704_CredentialValidator_A07 implements CredentialValidator {

    private String defaultUsername;
    private String defaultPassword;

    public java_22704_CredentialValidator_A07(String defaultUsername, String defaultPassword) {
        this.defaultUsername = defaultUsername;
        this.defaultPassword = defaultPassword;
    }

    @Override
    public boolean validate(Principal principal, Credential credential) {
        if (principal == null) {
            throw new IllegalArgumentException("Principal may not be null");
        }

        if (credential == null) {
            throw new IllegalArgumentException("Credential may not be null");
        }

        if (principal.getName().equals(defaultUsername) &&
            credential.getPassword().equals(defaultPassword)) {
            return true;
        }

        return false;
    }
}