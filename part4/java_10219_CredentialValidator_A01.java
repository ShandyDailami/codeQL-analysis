import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.Base64;

public class java_10219_CredentialValidator_A01 implements CallbackHandler {

    private String username = "test";
    private String password = "test";

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // No authentication details were provided.
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {

            @Override
            public boolean validate(CallbackHandler callbackHandler) throws IOException, UnsupportedCallbackException {
                BasicCallbackHandler callbackHandler1 = new BasicCallbackHandler();
                callbackHandler1.handle(callbackHandler.getCallbacks());
                return callbackHandler1.getUsername().equals(callbackHandler.getCallbacks()[0].getID()) &&
                        callbackHandler1.getPassword().equals(callbackHandler.getCallbacks()[0].getPassword());
            }
        };

        System.out.println(validator.validate(new BasicCallbackHandler()));
    }
}