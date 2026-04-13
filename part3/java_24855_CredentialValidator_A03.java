import javax.security.auth.Credential;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

public class java_24855_CredentialValidator_A03 implements Credential {

    private String username;
    private char[] password;

    public java_24855_CredentialValidator_A03(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getCaller() {
        return username;
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public boolean setNewPassword(char[] newPassword) {
        this.password = newPassword;
        return true;
    }

    @Override
    public boolean unsupported(String s) throws UnsupportedCallbackException {
        throw new UnsupportedCallbackException(s);
    }
}

public class Validator implements javax.security.auth.CredentialValidator {

    @Override
    public boolean validate(Subject subject, Credential credential) throws LoginException {
        if (credential instanceof UserCredentials) {
            UserCredentials userCredential = (UserCredentials) credential;
            return userCredential.getCaller().equals(userCredential.getName())
                    && Arrays.equals(userCredential.getPassword(), userCredential.getPassword());
        }
        return false;
    }

    @Override
    public boolean getCallerPrincipal(String arg0, Subject arg1, Credential arg2) throws LoginException {
        return false;
    }

    @Override
    public boolean getGroupPrincipals(String arg0, Subject arg1, Credential arg2) throws LoginException {
        return false;
    }

    @Override
    public boolean validate(Subject subject, Object object) throws LoginException {
        return validate(subject, (Credential) object);
    }
}