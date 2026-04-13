import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.UsernamePasswordCredential;

public class java_02117_CredentialValidator_A07 implements CredentialValidationResult, CredentialValidationResult.Status {
    private Credential credential;
    private CallbackHandler callbackHandler;
    private String callResult;

    public CredentialValidationResult validate(CallbackHandler callbackHandler) {
        this.callbackHandler = callbackHandler;
        return this;
    }

    public CredentialValidationResult validate(Credential credential) {
        this.credential = credential;
        return this;
    }

    public CredentialValidationResult getCredentialValidationResult() {
        if (credential != null && ((UsernamePasswordCredential) credential).getPassword().length() > 8) {
            callResult = Status.VALID.toString();
        } else {
            callResult = Status.INVALID.toString();
        }

        return this;
    }

    public void setResult(String result) {
        this.callResult = result;
    }

    public String getCallResult() {
        return callResult;
    }

    public String getStatus() {
        return callResult;
    }

    public void setStatus(String status) {
        this.callResult = status;
    }
}