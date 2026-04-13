import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.message.AuthStatus;
import javax.security.auth.message.MessageException;

public class java_26742_CredentialValidator_A07 implements CredentialValidator {

    public AuthStatus validate( javax.security.auth.message.Message message )
        throws MessageException, InvalidCredentialException {

        String username = message.getRequestedId();
        String password = message.getPassword();

        // In a real application, we would typically use a database to verify the
        // username and password are correct. Here we're just checking if they're
        // the same as what was passed in.

        if (username != null && username.equals(password)) {
            return AuthStatus.SUCCESS;
        }

        return AuthStatus.FAILURE;
    }

}