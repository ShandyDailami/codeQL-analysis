import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Properties;

public class java_19855_CredentialValidator_A07 implements CallbackHandler {
    private Properties props;

    public java_19855_CredentialValidator_A07() {
        try {
            InputStream in = getClass().getResourceAsStream("/credentials.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            if (callback instanceof PrincipalCallback) {
                PrincipalCallback pcCallback = (PrincipalCallback) callback;
                String principalId = pcCallback.getUsername();
                String password = props.getProperty(principalId);
                pcCallback.setPassword(password);
            }
        }
    }

    public static class PrincipalCallback implements Principal {
        private String principalId;
        private String password;

        public java_19855_CredentialValidator_A07(String principalId) {
            this.principalId = principalId;
        }

        @Override
        public String getName() {
            return principalId;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String getPassword() {
            return password;
        }
    }
}

public class UserNameValidator implements CredentialValidator {
    private UserPasswordCallbackHandler callbackHandler;

    public java_19855_CredentialValidator_A07() {
        callbackHandler = new UserPasswordCallbackHandler();
    }

    @Override
    public boolean validate(CredentialContext context) throws CredentialException {
        Callback[] callbacks = new Callback[1];
        callbacks[0] = new UserPasswordCallbackHandler.PrincipalCallback(context.getCallerPrincipal());
        try {
            callbackHandler.handle(callbacks);
        } catch (UnsupportedCallbackException e) {
            throw new CredentialException("Unsupported callback: " + e.getMessage());
        }
        if (callbacks[0].getPassword() != null) {
            context.setCallerPrincipal(callbacks[0].getName());
            context.setCredential(callbacks[0].getPassword());
            return true;
        }
        return false;
    }

    @Override
    public boolean getEnabled(CredentialContext context) throws CredentialException {
        return true;
    }
}