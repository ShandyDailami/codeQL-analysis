import javax.naming.AuthenticationException;
import javax.security.auth.message.callback.Callback;
import javax.security.auth.message.callback.CallbackHandler;
import javax.security.auth.message.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;

public class java_05882_CredentialValidator_A03 implements CallbackHandler {

    private static final String EXPECTED_USERNAME = "expectedUsername";

    @Override
    public Callback[] getCallbacks(String arg0) throws IOException,
            UnsupportedCallbackException {
        // This method is not used in this example.
        // It's here to satisfy the CallbackHandler interface's requirements.
        return null;
    }

    @Override
    public void handle(Callback[] arg0) throws IOException,
            UnsupportedCallbackException {
        String received = new String(Base64.getDecoder().decode(arg0[0].getContent()));

        if (!received.equals(EXPECTED_USERNAME)) {
            throw new AuthenticationException("Invalid username: " + received);
        }
    }

}

public class CustomValidator implements javax.security.auth.CredentialValidator {

    @Override
    public String getAuthorizationID() {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return null;
    }

    @Override
    public String getPassword() {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return null;
    }

    @Override
    public boolean validate(String arg0, String arg1) {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return false;
    }

    @Override
    public boolean validate(String arg0) {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return false;
    }

    @Override
    public void refresh() {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
    }

    @Override
    public CredentialValidationResult validate(Credential credential) {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return null;
    }

    @Override
    public CredentialValidationResult validate(Credential credential, String arg1) {
        // This method is not used in this example.
        // It's here to satisfy the CredentialValidator interface's requirements.
        return null;
    }

    @Override
    public CallbackHandler getCallbackHandler() {
        return new CustomCallbackHandler();
    }

}