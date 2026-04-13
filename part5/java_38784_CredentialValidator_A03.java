import java.util.Base64;
import java.util.Base64.Decoder;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordAuthentication;

public class java_38784_CredentialValidator_A03 implements CredentialValidator {

    private static final long serialVersionUID = 1L;
    private static final String ALGORITHM = "SHA-1";

    public PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("user", "password".getBytes(), null);
    }

    @Override
    public Credential validate(Credential c) throws LoginException {
        Credential credential = c;

        if (credential == null) {
            credential = new UsernamePasswordCredential(getPasswordAuthentication().getUserName(), getPasswordAuthentication().getPassword());
        }

        return credential;
    }

    @Override
    public boolean requires(String arg0) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CustomCredentialValidator;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}