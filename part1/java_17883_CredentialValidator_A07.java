import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeRequiredException;
import javax.security.auth.login.CredentialException;
import java.security.InvalidParameterException;

public class java_17883_CredentialValidator_A07 implements CredentialValidator {

    private String storedPassword;

    public java_17883_CredentialValidator_A07(String password) {
        this.storedPassword = password;
    }

    @Override
    public String getPassword() {
        return storedPassword;
    }

    @Override
    public boolean validate(String password) throws CredentialException {
        return password.equals(storedPassword);
    }

    @Override
    public boolean validate(String password, String token) throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void reset() throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void update(String password, String token) throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean getAcceptedPasswordLimit() throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void setPassword(String password) throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void setPassword(String password, String token) throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void setAcceptedPasswordLimit(boolean b) throws CredentialException {
        throw new UnsupportedOperationException("Not supported");
    }
}