import javax.security.auth.CredentialValidator;
import javax.security.auth.LoginException;
import javax.security.auth.UnknownAccountException;
import javax.security.auth.message.MessageException;

public class java_01432_CredentialValidator_A03 implements CredentialValidator {
    private String password;

    public java_01432_CredentialValidator_A03(String password) {
        this.password = password;
    }

    @Override
    public String validate(String arg0) throws MessageException, LoginException, UnknownAccountException {
        if (arg0.equals(password)) {
            return arg0;
        } else {
            throw new LoginException("Invalid password");
        }
    }

    @Override
    public boolean validate(Credential credential) throws MessageException, LoginException, UnknownAccountException {
        return validate(credential.getPassword());
    }
}