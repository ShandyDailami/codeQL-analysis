import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;
import java.util.Arrays;

public class java_29368_CredentialValidator_A03 implements CredentialValidator {

    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    @Override
    public Subject validate(Subject subject) throws InvalidCredentialException {
        String[] roles = subject.getPrincipal().toString().split(",");
        if (roles.length == 0) {
            throw new InvalidCredentialException("Invalid subject");
        }

        for (String role : roles) {
            if (role.equals("User")) {
                String password = subject.getCredentials()[0].toString();
                if (password.length() < MINIMUM_PASSWORD_LENGTH) {
                    throw new InvalidCredentialException("Password is too short. It should be at least " + MINIMUM_PASSWORD_LENGTH + " characters long");
                }
            }
        }

        return subject;
    }
}