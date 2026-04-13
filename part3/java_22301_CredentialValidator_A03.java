import java.util.Base64;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.Subject;

public class java_22301_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public String validate(Subject subject, String password) throws InvalidCredentialException {
        String userName = subject.getPrincipal().toString();
        String givenPassword = new String(Base64.getDecoder().decode(password));

        if (userName.equals(givenPassword)) {
            return password;
        } else {
            throw new InvalidCredentialException("Authentication failed.");
        }
    }
}