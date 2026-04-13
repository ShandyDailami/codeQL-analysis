import java.security.GeneralSecurityException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.UsernamePasswordCredential;

public class java_25759_CredentialValidator_A08 implements javax.security.auth.SubjectCredentialCallback {
    private Credential credential;

    public java_25759_CredentialValidator_A08() {
        credential = new UsernamePasswordCredential();
    }

    @Override
    public void validate(CredentialCredential credentialCredential) throws GeneralSecurityException {
        CredentialSubject subject = (CredentialSubject) credentialCredential.getSubject();
        credential.setName(subject.getIdentifier());
        credential.setPassword(subject.getCredential().getCredentials()[0].getPassword());

        if (!credential.matches(credentialCredential)) {
            throw new GeneralSecurityException("Invalid username or password");
        }
    }
}