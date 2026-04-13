import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;
import javax.security.auth.message.AuthException;

public class java_11796_CredentialValidator_A07 implements Credential {

    private String password;

    public java_11796_CredentialValidator_A07(String password) {
        this.password = password;
    }

    @Override
    public String getCredential() throws AuthException, CredentialException {
        return password;
    }

    @Override
    public boolean validate(String arg0) throws AuthException, CredentialException {
        return arg0.equals(password);
    }

}