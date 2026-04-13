import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.security.auth.CredentialValidator;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_15400_CredentialValidator_A01 implements CredentialValidator, LoginModule {
    private static final Map<String, String> validUsers = new HashMap<>();

    static {
        validUsers.put("alice", "alice");
        validUsers.put("bob", "bob");
        validUsers.put("charlie", "charlie");
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean validate(Subject subject, String password) {
        String username = subject.getPrincipal().toString();
        String expectedPassword = validUsers.get(username);
        return expectedPassword != null && expectedPassword.equals(password);
    }

    @Override
    public boolean commit() throws LoginException {
        return true;
    }

    @Override
    public boolean getAcceptedPasswordCharacteristics(String password, String passwordQuestion, String callerName) throws LoginException {
        return true;
    }
}