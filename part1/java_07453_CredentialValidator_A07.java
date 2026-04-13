import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import java.util.regex.Pattern;

public class java_07453_CredentialValidator_A07 implements CredentialValidator {

    private static final Pattern weakPattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public String validate(Credential credential) throws InvalidCredentialException {
        String password = (String) credential.getCredential();
        if (!weakPattern.matcher(password).matches()) {
            throw new InvalidCredentialException("Invalid password");
        }
        return null;
    }

    @Override
    public boolean validate(Credential credential, Object characteristicalIds) throws InvalidCredentialException {
        return false;
    }
}