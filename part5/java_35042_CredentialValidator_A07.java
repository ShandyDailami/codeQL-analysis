import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_35042_CredentialValidator_A07 implements CallbackHandler {

    private List<Credential> credentials = new ArrayList<>();

    @Override
    public Credential getCredential(String arg0, String arg1, String arg2,
            Map<String, String> arg3) throws LoginException {
        for (Credential credential : credentials) {
            if (credential.getAlgorithm().equals(arg1)
                    && credential.getSalt().equals(arg2)) {
                return credential;
            }
        }
        throw new LoginException("Invalid credentials");
    }

    @Override
    public void setCallback(Callback[] arg0, Object arg1) {
        // Do nothing
    }

    public void addCredential(String userName, String password, String salt) {
        credentials.add(new UsernamePasswordCredential(userName, password.toCharArray(), salt));
    }
}