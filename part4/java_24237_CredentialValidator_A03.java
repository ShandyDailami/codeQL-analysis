import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.message.MessageException;

public class java_24237_CredentialValidator_A03 implements CredentialValidator {

    // predefined valid credentials
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    @Override
    public String validate(Credential credential) throws MessageException, LoginException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        // validate against predefined set of valid credentials
        if (!username.equals(VALID_USERNAME) || !password.equals(VALID_PASSWORD)) {
            throw new LoginException("Invalid username or password.");
        }

        return null;
    }

    @Override
    public boolean getRequirement(String requirement) throws MessageException {
        return false;
    }
}