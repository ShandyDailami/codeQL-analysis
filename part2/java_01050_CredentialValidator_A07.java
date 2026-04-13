import java.security.InvalidParameterException;
import java.security.credential.Credential;
import java.security.credential.CredentialNotFoundException;
import java.security.credential.CredentialValidator;
import java.util.Base64;

public class java_01050_CredentialValidator_A07 implements CredentialValidator {

    private String encodedCredential;

    public java_01050_CredentialValidator_A07(String encodedCredential) {
        this.encodedCredential = encodedCredential;
    }

    @Override
    public Credential validate(Credential credential) throws CredentialNotFoundException, InvalidParameterException {
        String input = new String(credential.getPassword(), "UTF-8");
        if (Base64.getDecoder().decode(encodedCredential).equals(input)) {
            return credential;
        } else {
            throw new CredentialNotFoundException("Invalid Credentials");
        }
    }
}