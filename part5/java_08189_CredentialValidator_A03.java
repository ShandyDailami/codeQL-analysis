import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialDataException;
import javax.security.auth.login.CredentialException;

public class java_08189_CredentialValidator_A03 implements CredentialValidator {

    private static Map<String, String> credentialData = new HashMap<>();

    static {
        credentialData.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        credentialData.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
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
    public boolean validate(String callerPrincipal, String password) {
        return credentialData.containsKey(callerPrincipal) && password.equals(new String(Base64.getDecoder().decode(credentialData.get(callerPrincipal))));
    }

    @Override
    public void validate(String[] callerPrincipals, String[] passwords, String[] roles, String[] permissions) throws CredentialException, InvalidCredentialDataException {
        throw new UnsupportedOperationException();
    }

}