import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.LoginException;
import javax.security.auth.UnknownAccountException;
import java.util.Base64;

public class java_09247_CredentialValidator_A08 implements CredentialValidator {

    private final String hardCodedPassword;

    public java_09247_CredentialValidator_A08(String password) {
        this.hardCodedPassword = password;
    }

    @Override
    public String validate(String arg0) throws UnknownAccountException, InvalidCredentialException {
        if (arg0 == null) {
            throw new InvalidCredentialException("Password cannot be null");
        }
        String decodedPassword = new String(Base64.getDecoder().decode(arg0));
        if (decodedPassword.equals(this.hardCodedPassword)) {
            return arg0;
        } else {
            throw new InvalidCredentialException("Invalid password");
        }
    }

    @Override
    public boolean validate(String arg0, Object arg1) throws LoginException {
        return false;
    }

    @Override
    public boolean validate(CredentialContext arg0) throws LoginException {
        return false;
    }
}