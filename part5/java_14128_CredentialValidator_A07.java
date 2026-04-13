import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.ServiceConfigurationError;
import java.security.Guard;
import java.security.Permission;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Set;

public class java_14128_CredentialValidator_A07 implements CredentialValidationResult, CallbackHandler {
    private String userName;
    private String password;

    public java_14128_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate(Callback[] callbacks) {
        for (Callback callback : callbacks) {
            if (callback instanceof UserCredentialValidatorCallback) {
                UserCredentialValidatorCallback credentialCallback = (UserCredentialValidatorCallback) callback;
                try {
                    credentialCallback.setUsername(userName);
                    credentialCallback.setPassword(password);
                    return CredentialValidationResult.success();
                } catch (LoginException e) {
                    return CredentialValidationResult.failed();
                }
            }
        }
        return CredentialValidationResult.unknown();
    }

    @Override
    public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
        validate(callbacks);
    }

    static class UserCredentialValidatorCallback implements Callback {
        private String username;
        private String password;

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public Permission getPermission() {
            return null;
        }

        @Override
        public ProtectionDomain getProtectionDomain() {
            return null;
        }

        @Override
        public Guard getGuard() {
            return null;
        }
    }
}