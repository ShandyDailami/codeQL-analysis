import javax.security.auth.Credential;
import javax.security.auth.Destination;
import javax.security.auth.callback.*;
import javax.security.auth.login.*;
import javax.security.auth.module.*;
import javax.security.auth.spi.*;
import javax.security.auth.x500.X500Principal;

public class java_11433_CredentialValidator_A01 implements CredentialValidator {

    public Destination getDestination() throws AuthenticationException {
        return null;
    }

    public Credential getCredential(String challenge) throws AuthenticationException {
        return null;
    }

    public boolean validate(Credential credential) throws AuthenticationException {
        // This example always returns true
        return true;
    }

    public boolean validate(Credential credential, Destination destination) throws AuthenticationException {
        // This example always returns true
        return true;
    }

    public static void main(String[] args) {
        try {
            CustomCredentialValidator validator = new CustomCredentialValidator();
            System.out.println(validator.validate(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}