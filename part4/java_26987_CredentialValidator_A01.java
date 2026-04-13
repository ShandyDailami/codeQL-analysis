import javax.security.auth.Credential;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.CredentialException;

public class java_26987_CredentialValidator_A01 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        String presentedUsername = credential.getIdentifier();
        String presentedPassword = (String) credential.getCredential();

        if ("".equals(presentedUsername) || "".equals(presentedPassword)) {
            throw new CredentialException("Username and password must be provided.");
        }

        return USERNAME.equals(presentedUsername) && PASSWORD.equals(presentedPassword);
    }

    @Override
    public boolean getAccountStatus() {
        return false;
    }

    @Override
    public void clearAccountStatus() {
        //do nothing
    }

    @Override
    public boolean commit() throws PasswordChangeException {
        return false;
    }

    @Override
    public boolean upgradeAccount() throws PasswordChangeException {
        return false;
    }
}