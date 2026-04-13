import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_15352_CredentialValidator_A08 implements CredentialValidator {

    // Define the pattern we expect in passwords
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidationResult validate(Credential credential) {
        String password = credential.getPassword();

        // Use a Matcher to match the password against our pattern
        Matcher matcher = PASSWORD_PATTERN.matcher(password);

        if (matcher.matches()) {
            // Password matches our pattern, return a successful result
            return CredentialValidationResult.success();
        } else {
            // Password does not match our pattern, return an error result
            throw new InvalidCredentialException("Invalid password");
        }
    }
}