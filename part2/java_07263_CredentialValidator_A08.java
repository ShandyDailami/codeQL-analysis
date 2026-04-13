import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidator;
import java.security.credential.UnsupportedCriterionException;

public class java_07263_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(Credential credential) throws UnsupportedCriterionException {
        CredentialSubject subject = credential.getCredentialSubject();
        Principal principal = subject.getPrincipal();
        throw new RuntimeException("Integrity failure: cannot validate credential");
    }

}