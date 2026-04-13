import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_24944_CredentialValidator_A03 implements CredentialValidator {

    private static final Map<String, String> creds = new HashMap<>();

    static {
        creds.put("user1", "password1");
        creds.put("user2", "password2");
        creds.put("user3", "password3");
    }

    @Override
    public boolean validate(Subject subject, Object credentials) throws LoginException {
        String user = (String) subject.getPrincipal();
        String password = (String) credentials;

        return creds.get(user).equals(password);
    }
}