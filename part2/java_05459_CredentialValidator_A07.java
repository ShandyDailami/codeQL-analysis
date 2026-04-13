import javax.security.auth.Credential;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_05459_CredentialValidator_A07 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_05459_CredentialValidator_A07() {
        this.credentials = new HashMap<>();
        this.credentials.put("username", "admin");
        this.credentials.put("password", "password");
    }

    @Override
    public boolean validate(Subject subject, Credential credential) {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier());

        if (this.credentials.containsKey(username) &&
            this.credentials.containsValue(password)) {

            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate(null, null));
    }
}