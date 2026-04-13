import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.security.credential.CredentialValidationResult;
import java.util.HashMap;
import java.util.Map;

public class java_38336_CredentialValidator_A03 implements CredentialValidator {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(Credential credential) {
        CredentialValidationResult result;

        // Retrieve username and password from credential
        Map<String, String> credentialAttributes = new HashMap<>();
        credentialAttributes.put(CredentialSubject.USERNAME_ATTRIBUTE, USERNAME);
        credentialAttributes.put(CredentialSubject.PASSWORD_ATTRIBUTE, PASSWORD);

        if (credential.getAttributes().equals(credentialAttributes)) {
            result = CredentialValidationResult.VALID_RESULT;
        } else {
            result = CredentialValidationResult.INVALID_RESULT;
        }

        return result;
    }
}