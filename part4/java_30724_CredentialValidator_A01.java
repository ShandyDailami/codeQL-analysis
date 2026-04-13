import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Base64;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_30724_CredentialValidator_A01 implements CredentialValidator {

    private final MessageDigest md;

    public java_30724_CredentialValidator_A01() {
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Principal validate(Credential credential) throws InvalidCredentialException {
        String input = new String(credential.getCredential());
        String encoded = Base64.getEncoder().encodeToString(md.digest(input.getBytes()));
        return new StringCredential(input, encoded);
    }

    @Override
    public boolean validate(Credential credential, Principal expected) throws InvalidCredentialException {
        return false;
    }

    @Override
    public boolean validate(Credential credential) throws InvalidCredentialException {
        return false;
    }
}