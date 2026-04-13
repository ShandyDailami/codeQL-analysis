import java.security.InvalidParameterException;

public class java_41929_CredentialValidator_A03 {

    public interface Credential {
        String getUsername();
        String getPassword();
    }

    public interface CredentialValidator {
        void validate(Credential credential) throws InvalidParameterException;
    }

    private CredentialValidator credentialValidator;

    public java_41929_CredentialValidator_A03(CredentialValidator validator) {
        this.credentialValidator = validator;
    }

    public void setCredentialValidator(CredentialValidator validator) {
        this.credentialValidator = validator;
    }

    public void validate(Credential credential) throws InvalidParameterException {
        if (credential == null) {
            throw new InvalidParameterException("Credential can't be null.");
        }
        if (credential.getUsername() == null || credential.getUsername().trim().isEmpty()) {
            throw new InvalidParameterException("Username can't be null or empty.");
        }
        if (credential.getPassword() == null || credential.getPassword().trim().isEmpty()) {
            throw new InvalidParameterException("Password can't be null or empty.");
        }
        credentialValidator.validate(credential);
    }
}