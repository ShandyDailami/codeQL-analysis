import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.username.UsernamePasswordCallback;
import javax.security.auth.validate.ValidateException;

public class java_09084_CredentialValidator_A03 implements CallbackHandler {

    @Override
    public CallbackHandler getInstance(Subject subject, String authMethod) throws ValidateException {
        return this;
    }

    @Override
    public Callback[] getCallbacks() throws UnsupportedCallbackException {
        return new Callback[]{new UsernamePasswordCallback("")};
    }

    @Override
    public void refresh(Subject subject, Callback[] callbacks) throws UnsupportedCallbackException, ValidateException {
    }

    public boolean validate(String usernameParameter, String passwordParameter) throws ValidateException {
        if ("username".equals(usernameParameter) && "password".equals(passwordParameter)) {
            return true;
        } else {
            throw new ValidateException("Authentication failed");
        }
    }
}