import javax.security.auth.CredentialValidationResult;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.usernamePasswordAuthentication;
import javax.security.auth.spi.Service;
import java.io.IOException;
import java.util.Base64;

public class java_30502_CredentialValidator_A08 implements Service {

    private String user = "user";
    private String password = "password";

    @Override
    public String getMessage(String s) throws IOException, UnsupportedCallbackException {
        return null;
    }

    @Override
    public String getName() {
        return "CustomService";
    }

    @Override
    public String getStatus() {
        return "Inactive";
    }

    @Override
    public void initialize(CallbackHandler callbackHandler, Map<String, ?> map) throws UnsupportedCallbackException {
        Callback callback = new Callback() {
            public void validate(Callback callback) {
                usernamePasswordAuthentication auth = (usernamePasswordAuthentication) callback;
                String providedId = new String(Base64.getDecoder().decode(auth.getRequestedInfo().getParameter(Service.PLAIN_PASSWORD_TEXT)));

                if (user.equals(providedId)) {
                    callback.setRequestedInfo(new AuthenticationInfoBuilder(user, null, null).buildInfo());
                    callback.completed(new CredentialValidationResult(user, "CustomService"));
                } else {
                    throw new AuthenticationFailedException("Authentication failed");
                }
            }
        };

        callbackHandler.handle(callback, false);
    }
}