import java.security.GeneralSecurityException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidator;
import java.security.credential.InvalidCredentialException;

public class java_30085_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public void validate(Credential credential) throws InvalidCredentialException, GeneralSecurityException {
        // Extract the CredentialSubject
        CredentialSubject credentialSubject = credential.getCredentialSubject();

        // Validate the CredentialSubject
        if ("username".equals(credentialSubject.getIdentifier()) && "password".equals(credentialSubject.getPasswordAsString())) {
            return;
        }

        // Throw an InvalidCredentialException if the CredentialSubject is invalid
        throw new InvalidCredentialException("Invalid credentials");
    }
}