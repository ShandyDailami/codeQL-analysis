import java.util.Arrays;
import java.util.List;

import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;

public class java_04781_CredentialValidator_A03 implements CredentialValidator {

    private static final List<String> ALLOWED_USERS = Arrays.asList("user1", "user2", "user3");
    private static final List<String> ALLOWED_PASSWORDS = Arrays.asList("pass1", "pass2", "pass3");

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        if (ALLOWED_USERS.contains(credential.getIdentifier())
                && ALLOWED_PASSWORDS.contains(String.valueOf(credential.getPassword()))) {
            return null; // credentials are valid
        } else {
            return new javax.security.auth.UnavailableException("Invalid username or password");
        }
    }

}