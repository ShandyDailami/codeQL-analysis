import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_21736_CredentialValidator_A01 implements LoginModule {

    private Map<String, String> credentials = new HashMap<>();

    public java_21736_CredentialValidator_A01() {
        // This should be a set of hardcoded credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public String getName() {
        return "CustomLoginModule";
    }

    @Override
    public String getCallerPrincipal() {
        return "user";
    }

    @Override
    public String getPassword() {
        return credentials.get(getName());
    }

    @Override
    public CredentialValidationResult validate(Map<String, Object> map) throws LoginException {
        CredentialValidationResult result;

        String user = (String) map.get("callerPrincipal");
        String password = (String) map.get("callerCredential");

        if (credentials.containsKey(user) && credentials.get(user).equals(password)) {
            result = new CredentialValidationResult("Success", new Object[]{getName()});
        } else {
            result = new CredentialValidationResult("Unknown User", null);
        }

        return result;
    }
}