import com.sun.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginContext;
import java.util.Base64;
import java.security.Principal;
import java.security.Permissions;
import java.security.Guard;

public class java_42035_CredentialValidator_A01 {
    private String username;
    private char[] password;

    public java_42035_CredentialValidator_A01(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate(PasswordCallback callback) throws Exception {
        String expectedPassword = new String(Base64.getDecoder().decode(this.password));

        LoginContext context = new LoginContext(username, new Guard(){
            public Principal getPrincipal(){ return null;}});
        context.setPasswordCallback(callback);

        context.authenticate(null);

        return context.getAuthenticatedPrincipal() != null;
    }
}