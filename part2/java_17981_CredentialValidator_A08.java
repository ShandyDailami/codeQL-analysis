import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.security.Principal;

public class java_17981_CredentialValidator_A08 implements CallbackHandler {
    private char[] password;

    public java_17981_CredentialValidator_A08(String password) {
        this.password = password.toCharArray();
    }

    @Override
    public void handle(Callback callback) throws UnsupportedCallbackException, IOException {
        if (callback instanceof PasswordCallback) {
            PasswordCallback pc = (PasswordCallback) callback;
            pc.setPassword(this.password);
        }
    }
}

public class CredentialValidator {
    private static final String SECRET = "mysecret";

    public static void main(String[] args) {
        CallbackHandler handler = new SimplePasswordCallback(SECRET);
        AuthPermission perm = new AuthPermission("");
        CredentialEvaluator evaluator = new CredentialEvaluator(handler, perm, SECRET);
        evaluator.validate(null);
    }
}