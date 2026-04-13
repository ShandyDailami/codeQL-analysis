import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.CredentialCaller;
import javax.security.auth.callback.CredentialStatus;
import javax.security.auth.callback.UnavailableCallbackException;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.subject.SubjectCredentials;
import javax.security.auth.login.LoginException;

public class java_31578_CredentialValidator_A07 implements CredentialValidatorCallback {
    private String userName;
    private String password;

    public java_31578_CredentialValidator_A07(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public CredentialValidatorCallback getInstance(String userName, String password) {
        return new CredentialValidator(userName, password);
    }

    public CredentialStatus validate(Subject subject, CredentialCaller caller, String userName, String password) throws LoginException, UnavailableCallbackException, UnsupportedCallbackException {
        if (userName.equals(this.userName) && password.equals(this.password)) {
            return CredentialStatus.SUCCESS;
        } else {
            return CredentialStatus.FAILURE;
        }
    }
}

public class CredentialValidatorCallback implements CredentialCallback {
    private CredentialValidator validator;

    public CredentialCallback getInstance(String userName, String password) {
        validator = new CredentialValidator(userName, password);
        return this;
    }

    public void setValidator(CredentialValidator validator) {
        this.validator = validator;
    }

    public CredentialValidator getValidator() {
        return validator;
    }

    public void call(String prompt) throws IOException, UnavailableCallbackException {
        // Do nothing
    }

    public void setRequest(String request) throws UnavailableCallbackException {
        // Do nothing
    }
}

public class CredentialValidatorCallbackHandler implements CallbackHandler {
    private CredentialCallback[] callbacks;

    public java_31578_CredentialValidator_A07(CredentialCallback... callbacks) {
        this.callbacks = callbacks;
    }

    public CredentialStatus validate(Subject subject, String caller, String password) throws LoginException {
        for (CredentialCallback callback : callbacks) {
            callback.setRequest("");
            CredentialStatus status = callback.validate(subject, new UnsupportedCallbackException("Unsupported callback"));
            if (status != CredentialStatus.SUCCESS) {
                return status;
            }
        }
        return CredentialStatus.SUCCESS;
    }

    public CallbackHandler getInstance(CredentialCallback... callbacks) {
        return new CredentialValidatorCallbackHandler(callbacks);
    }
}