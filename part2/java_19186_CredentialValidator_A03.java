import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class java_19186_CredentialValidator_A03 implements CallbackHandler {

    private final Map<String, String> userCredentials = new HashMap<>();

    public java_19186_CredentialValidator_A03() {
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback : callbacks) {
            // No action needed in this example
        }
    }

    public Subject.AuthStatus validate(Subject subject, String callingPrincipal, String callingAccessGroup, Object credentials) {
        String user = callingPrincipal;
        String pass = (String) credentials;

        String storedPass = userCredentials.get(user);

        if (storedPass != null && storedPass.equals(pass)) {
            return Subject.AuthStatus.SUCCESSFUL;
        } else {
            return Subject.AuthStatus.FAILURE;
        }
    }
}

public class CredentialValidator {

    public static void main(String[] args) {
        javax.security.auth.spi.LoginModuleFactory factory =
            javax.security.auth.spi.LoginModuleFactory.getDefault();
        LoginModule module = factory.createLoginModule("CustomRealm", new CustomCallbackHandler());
        Subject subject = new Subject(null, null, null);
        try {
            subject.getPrivateCredentials(module);
            subject.authenticate(module);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}