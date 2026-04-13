import javax.security.auth.Credential;
import javax.security.auth.CredentialValidationResult;
import javax.security.auth.PasswordAuthentication;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_22797_CredentialValidator_A08 implements LoginModule {
    private String user;
    private String password;

    @Override
    public void initialize( javax.security.auth.login.LoginContext loginContext,
                           javax.security.auth.Subject subject,
                           String userName, String password ) throws LoginException {
        this.user = userName;
        this.password = password;
    }

    @Override
    public CredentialValidationResult validate( final Credential credential ) {
        PasswordAuthentication pa = (PasswordAuthentication) credential;
        String inputPassword = new String(pa.getPassword());

        if (user.equals("admin") && password.equals(inputPassword)) {
            return CredentialValidationResult.VALID;
        } else {
            return CredentialValidationResult.INVALID;
        }
    }
}