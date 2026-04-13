import java.security.InvalidParameterException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordToken;

public class java_03309_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public UsernamePasswordToken validate(UsernamePasswordToken arg0) throws InvalidParameterException {
        String userName = arg0.getCallerPrincipal();
        String password = arg0.getPassword();

        if (userName == null || userName.isEmpty()) {
            throw new InvalidParameterException("Username cannot be null or empty.");
        }

        if (password == null || password.isEmpty() || password.length() < 6) {
            throw new InvalidParameterException("Password cannot be null, empty or less than 6 characters.");
        }

        return arg0;
    }

}