import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.subject.Subject;
import javax.security.auth.Subject.State;

public class java_25381_CredentialValidator_A01 implements CallbackHandler {
    private String user = "admin";
    private String password = "admin";

    public java_25381_CredentialValidator_A01() {
    }

    public Subject login() throws LoginException {
        Credential credential = new UsernamePasswordCredential("admin", "admin");
        Subject subject = Subject.login(credential);
        return subject;
    }

    public boolean validate(Subject subject, String password) {
        if (subject != null && subject.getPrincipal() != null) {
            return subject.getPrincipal().equals(this.user);
        } else {
            return false;
        }
    }

    public CredentialValidationCallback getCallback() {
        return new CredentialValidationCallback();
    }

    public CredentialValidationCallback getCallback(String name) {
        return new CredentialValidationCallback(name);
    }

    public CredentialValidationCallback getCallback(String name, String password) {
        return new CredentialValidationCallback(name, password);
    }

    public class CredentialValidationCallback implements Callback {
        private String name;
        private String password;

        public java_25381_CredentialValidator_A01() {
        }

        public java_25381_CredentialValidator_A01(String name) {
            this.name = name;
        }

        public java_25381_CredentialValidator_A01(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean validate(Subject subject, Object credentials) throws LoginException {
            if (subject == null || credentials == null) {
                return false;
            } else {
                return validate(subject, (String) credentials);
            }
        }

        public boolean validate(Subject subject, String password) throws LoginException {
            if (subject == null) {
                return false;
            } else {
                return this.validate(subject, password);
            }
        }

        public boolean validate(Subject subject, Object credentials) throws LoginException {
            if (subject == null || credentials == null) {
                return false;
            } else {
                return this.validate(subject, (String) credentials);
            }
        }

        public boolean validate(Subject subject, Object credentials) throws LoginException {
            if (subject == null) {
                return false;
            } else {
                return this.validate(subject, (String) credentials);
            }
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getName() {
            return this.name;
        }

        public String getPassword() {
            return this.password;
        }
    }
}