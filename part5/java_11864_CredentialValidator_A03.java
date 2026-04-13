import java.security.Credential;
import java.security.AccessControlException;

public class java_11864_CredentialValidator_A03 implements CredentialValidator {

    // Credential validator to use
    private Credential credential;

    // The constructor requires a credential to use
    public java_11864_CredentialValidator_A03(Credential c) {
        this.credential = c;
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws AccessControlException {
        // The 'validate' method of the CredentialValidator interface
        // returns a CredentialValidationResult enumeration that represents the result of the validation

        // We compare the input credential with our stored credential
        if (c.equals(credential)) {
            return CredentialValidationResult.VALIDATE_SUCCESSFULLY;
        } else {
            return CredentialValidationResult.VALIDATE_FAILED;
        }
    }
}