import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.UnknownUserException;
import javax.security.auth.login.CredentialException;

public class java_31676_CredentialValidator_A01 implements CredentialValidator {

    private Map<String, String> credentials;

    public java_31676_CredentialValidator_A01() {
        this.credentials = new HashMap<>();
        this.credentials.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        this.credentials.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    @Override
    public String validate(String arg0) throws UnknownUserException, CredentialException {
        String user = arg0;
        String password = this.credentials.get(user);
        if (password == null) {
            throw new UnknownUserException("Unknown user");
        }
        return password;
    }

    @Override
    public String getCallerPrincipal() {
        return null;
    }

    @Override
    public String getPassword() throws CredentialException {
        return null;
    }

    @Override
    public boolean get hassPassword(boolean arg0) {
        return false;
    }

    @Override
    public String getAuthType() {
        return null;
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public boolean validate(Object arg0, Object arg1) throws InvalidCredentialDataException, CredentialException {
        return false;
    }
}