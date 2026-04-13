import java.security.InvalidParameterException;
import java.security.auth.Credential;
import java.security.auth.PasswordAuthentication;
import java.security.auth.Subject;
import java.security.auth.callback.Callback;
import java.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.List;

public class java_20518_CredentialValidator_A08 implements CredentialValidator {

    private String expectedPassword;

    public java_20518_CredentialValidator_A08(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    @Override
    public boolean validate(Subject subject, Credential credential) {
        String providedPassword = credential.getPassword();
        return expectedPassword.equals(providedPassword);
    }

    @Override
    public boolean getRequestedCredentials(Credential credential) {
        return false;
    }

    @Override
    public boolean supports(String authenticationId) {
        return true;
    }

    @Override
    public boolean validate(Credential credential, Object object) {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().equals(this.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }

    @Override
    public String getId() {
        return this.getClass().getName();
    }

    @Override
    public List<CallbackHandler> getCallbackHandlers() {
        return new ArrayList<>();
    }

    @Override
    public void setCallbackHandler(CallbackHandler callbackHandler) {
        // Not used
    }

    @Override
    public void initialize(String arg0, Properties arg1) throws InvalidParameterException {
        // Not used
    }
}