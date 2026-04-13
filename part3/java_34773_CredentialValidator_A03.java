import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.security.GuardianURL;
import java.security.GuardianSecurityManager;
import java.security.PrivilegedAction;

public class java_34773_CredentialValidator_A03 implements CredentialValidator {

    private String username;
    private String password;

    public java_34773_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(Subject subject, Object credentials, CallbackHandler callbackHandler) throws LoginException, UnsupportedCallbackException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new UsernamePasswordCallback("User Name", this.username);
        callbacks[1] = new UsernamePasswordCallback("Password", this.password);

        callbackHandler.handle(callbacks);

        return true;
    }

    private static class UsernamePasswordCallback implements Callback {
        private String prompt;
        private String answer;

        public java_34773_CredentialValidator_A03(String prompt, String answer) {
            this.prompt = prompt;
            this.answer = answer;
        }

        public String getPrompt() {
            return prompt;
        }

        public String getPassword() {
            return answer;
        }

        public boolean handle(Callback callback) {
            if (callback instanceof UsernamePasswordCallback) {
                answer = (String) ((UsernamePasswordCallback) callback).getPassword();
                return true;
            }
            return false;
        }
    }
}