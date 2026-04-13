import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_11547_CredentialValidator_A08 implements CredentialValidator {

    private static final String VALID_PATTERN = "my_valid_pattern";

    @Override
    public String validate(String arg0) throws CredentialException, InvalidCredentialException {
        if (VALID_PATTERN.equals(arg0)) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid credential");
        }
    }

    @Override
    public boolean validate(String arg0, Object arg1) throws CredentialException, InvalidCredentialException {
        return validate(arg0);
    }

}