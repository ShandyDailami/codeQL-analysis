import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_00089_CredentialValidator_A07 {

    public boolean authenticate(String username, String password) {
        Credential credential;

        try {
            credential = new UsernamePasswordCredential(username, password);
            javax.security.auth.AuthResult authResult = javax.security.auth.callback.UnavailableCallbackContext.get(null).authenticate(credential);
            return authResult.getState() == AuthResult.SUCCESS_CREDENTIAL;
        } catch (LoginException e) {
            e.printStackTrace();
            return false;
        }
    }

}