import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.UsernamePasswordToken;
import java.util.Arrays;

public class java_14710_CredentialValidator_A03 implements CredentialValidator {
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    @Override
    public UsernamePasswordToken validate(UsernamePasswordToken arg0) throws InvalidCredentialException {
        if (arg0.getIdentifier() == null) {
            throw new InvalidCredentialException("Username not provided");
        }

        if (arg0.getPassword() == null) {
            throw new InvalidCredentialException("Password not provided");
        }

        if (Arrays.asList(VALID_USERNAME, VALID_PASSWORD).equals(Arrays.asList(arg0.getIdentifier(), arg0.getPassword()))) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid username or password");
        }
    }
}