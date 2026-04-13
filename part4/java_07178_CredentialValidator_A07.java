import javax.security.auth.AuthFailureure;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.AbstractLoginModule;
import javax.security.auth.validation.AbstractValidationResult;

public class java_07178_CredentialValidator_A07 extends AbstractLoginModule {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    @Override
    public CredentialValidationResult validate( javax.security.auth.AuthenticationToken arg0 ) throws LoginException {
        String userName = arg0.getIdentifier();
        String password = arg0.getCredentials().toString();

        if (expectedUsername.equals(userName) && expectedPassword.equals(password)) {
            return new AbstractValidationResult() {
                @Override
                public boolean success() {
                    return true;
                }

                @Override
                public Object getCredentials() {
                    return password;
                }

                @Override
                public Object getChallenges() {
                    return null;
                }
            };
        } else {
            return new AuthFailureure("Invalid Credentials");
        }
    }
}