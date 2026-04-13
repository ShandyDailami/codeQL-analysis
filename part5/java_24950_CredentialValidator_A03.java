import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialValidationResult;
import javax.security.auth.credential.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_24950_CredentialValidator_A03 implements javax.security.auth.credential.CredentialValidator {

    private static final Set<String> VALID_USERS = new HashSet<String>() {
        {
            add("user1");
            add("user2");
            add("user3");
        }
    };
    private static final Set<String> VALID_PASSWORDS = new HashSet<String>() {
        {
            add("password1");
            add("password2");
            add("password3");
        }
    };

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentialIdentifier());

        if (VALID_USERS.contains(username) && VALID_PASSWORDS.contains(password)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.NOT_VALIDATED_REQUEST;
        }
    }

}