import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.credential.Credential;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.x500.X500Principal;

public class java_11166_CredentialValidator_A03 implements CredentialValidator {
    private static final String USER_DN = "CN=user,OU=Users,DC=example,DC=com";
    private static final String PASSWORD = "password";

    @Override
    public Credential validate(CredentialContext context) throws LoginException {
        Map<String, String> requestProperties = new HashMap<>();
        requestProperties.put("LDAP_DN", USER_DN);
        requestProperties.put("LDAP_PASSWORD", PASSWORD);

        context.setRequestProperties(requestProperties);

        return new UsernamePasswordCredential(USER_DN, PASSWORD);
    }
}