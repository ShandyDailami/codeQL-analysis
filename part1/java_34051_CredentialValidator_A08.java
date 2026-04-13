import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.UsernamePasswordCredential;
import java.util.Arrays;
import java.util.List;

public class java_34051_CredentialValidator_A08 implements CredentialValidator {

    // List of known bad usernames
    private List<String> badUsernames = Arrays.asList("baduser1", "baduser2", "baduser3");

    @Override
    public CredentialValidationResult validate(UsernamePasswordCredential arg0) {
        String username = arg0.getIdentifier();
        if (badUsernames.contains(username)) {
            return CredentialValidationResult.failed();
        }
        return CredentialValidationResult.success();
    }
}