import javax.security.auth.CredentialValidationResult;
import javax.security.auth.login.CredentialException;
import javax.security.auth.validation.Validator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_25628_CredentialValidator_A07 implements Validator {

    private Set<String> validUsers = new HashSet<>(Arrays.asList("admin", "user1", "user2"));
    private Set<String> validPasswords = new HashSet<>(Arrays.asList("password", "password123", "123password"));

    @Override
    public CredentialValidationResult validate(Credential c) throws CredentialException {
        String user = c.getCredentialIdentifier();
        String password = c.getCredential();

        if(validUsers.contains(user) && validPasswords.contains(password)) {
            return new CredentialValidationResult("Success", null);
        } else {
            return new CredentialValidationResult("Failure", null);
        }
    }
}