import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnavailableCallbackException;
import javax.security.auth.username.UsernamePasswordAuthenticationMechanism;
import javax.security.auth.username.UsernamePasswordValidation;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class java_20647_CredentialValidator_A07 implements CredentialValidator, CallbackHandler {
    private String user;
    private char[] password;

    @Override
    public boolean validate(CallbackHandler callbackHandler, Properties props) throws CredentialNotFoundException, FailedLoginException, UnavailableCallbackException {
        UsernamePasswordValidation usernamePasswordValidation = new UsernamePasswordValidation();
        usernamePasswordValidation.setCallbackHandler(this);
        return usernamePasswordValidation.validate(new Callback[]{new Callback() {
            @Override
            public void handle(String s) throws IOException, UnavailableCallbackException {
                user = s;
            }

            @Override
            public boolean getCredential(String s, String s1, String s2) throws CredentialNotFoundException, FailedLoginException {
                password = s1.toCharArray();
                return true;
            }
        }});
    }

    public String getUser() {
        return user;
    }

    public char[] getPassword() {
        return password;
    }

    public static void main(String[] args) throws Exception {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        validator.validate(null, null);
        System.out.println("User: " + validator.getUser());
        System.out.println("Password: " + Base64.getEncoder().encodeToString(validator.getPassword()));
    }
}