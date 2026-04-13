import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_37239_CredentialValidator_A03 implements CallbackHandler {

    private Map<String, String> credentials;

    public java_37239_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
    }

    public void addCredential(String realm, String password) {
        this.credentials.put(realm, password);
    }

    @Override
    public Callback handle(Callback callback) throws IOException, LoginException {
        if (!(callback instanceof UsernamePasswordCallback)) {
            callback.done(null, null);
            return null;
        }

        UsernamePasswordCallback callbackObj = (UsernamePasswordCallback) callback;

        if (credentials.containsKey(callbackObj.getPrompt())) {
            String password = credentials.get(callbackObj.getPrompt());
            callbackObj.setPassword(password.toCharArray());
        } else {
            callbackObj.setStatus("Error: Invalid Credentials");
        }

        callback.done(null, null);
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.addCredential("myRealm", "myPassword");

        CallbackHandler handler = validator;

        Subject.authenticate(handler, new NamePasswordCallback("user", "password"));
    }
}