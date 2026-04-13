import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.AccessControlAction;
import java.security.AccessControlListener;
import java.security.AccessControlSubject;

public class java_25510_CredentialValidator_A01 implements CredentialValidator {

    private String user;
    private String password;

    public java_25510_CredentialValidator_A01(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public Subject getSubject(CallbackHandler callbackHandler)
            throws IOException, UnsupportedCallbackException {
        Callback[] callbacks = new Callback[]{new UsernamePasswordCallback()};
        callbackHandler.handle(callbacks);

        String name = ((UsernamePasswordCallback) callbacks[0]).getIdentifier();
        String password = ((UsernamePasswordCallback) callbacks[0]).getPassword();

        // Assuming user enters correct username and password for simplicity
        if (!name.equals(this.user) || !password.equals(this.password)) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        return new CustomSubject(this.user);
    }

    private class CustomSubject implements AccessControlSubject {

        private String principal;

        public java_25510_CredentialValidator_A01(String user) {
            this.principal = user;
        }

        @Override
        public String getPrincipal() {
            return principal;
        }

        @Override
        public void setPrincipal(String principal) {
            this.principal = principal;
        }

        @Override
        public void runAs(String user) throws SecurityException {
            // Do nothing
        }

        @Override
        public void removeAs(String user) {
            // Do nothing
        }

        @Override
        public void permitCollectionAttributeAccess() {
            // Do nothing
        }

        @Override
        public void permitCollectionOps(AccessControlAction action) {
            // Do nothing
        }

        @Override
        public void permitContainerOps(AccessControlAction action) {
            // Do nothing
        }

        @Override
        public void permitAlterSessionControlOps() {
            // Do nothing
        }

        @Override
        public void permitAll() {
            // Do nothing
        }

        @Override
        public void denyAll() {
            // Do nothing
        }
    }

    private class UsernamePasswordCallback implements Callback {

        private String identifier;
        private char[] password;

        @Override
        public void setIdentifier(String identifier) {
            this.identifier = identifier;
        }

        @Override
        public String getIdentifier() {
            return identifier;
        }

        @Override
        public char[] getPassword() {
            return password;
        }

        @Override
        public void clearPassword() {
            password = null;
        }

        @Override
        public boolean promptPassword(String prompt) {
            // Do nothing, return true to indicate that password is not required
            return true;
        }

        @Override
        public void setPassword(char[] password) {
            this.password = password;
        }

        @Override
        public boolean supportsPasswordCallback() {
            // Return true to indicate that password is not required
            return true;
        }
    }

    private class InvalidCredentialsException extends Exception {
        // Do nothing
    }
}