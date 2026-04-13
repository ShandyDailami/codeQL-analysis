import java.security.GeneralSecurityException;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidator;
import java.security.credential.CredentialProvider;
import java.security.credential.CredentialContext;

public class java_32901_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_32901_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(CredentialContext context, Credential credential) throws GeneralSecurityException {
        CredentialSubject subject = (CredentialSubject) credential.getCredentialSubject();
        String user = subject.getIdentifier();
        String pass = subject.getPassword().toString();
        return user.equals(this.username) && pass.equals(this.password);
    }
}