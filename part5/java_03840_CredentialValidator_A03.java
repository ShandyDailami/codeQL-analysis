import javax.security.auth.CredentialValidator;
import javax.security.auth.CredentialValidatorResult;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Pattern;

public class java_03840_CredentialValidator_A03 implements CredentialValidator {

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidatorResult validate(Credential credential) throws InvalidCredentialException {
        String password = credential.getPassword();
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidatorResult.VALID;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }
}