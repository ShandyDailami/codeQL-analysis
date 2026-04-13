import java.security.Credential;
import java.security.AccessControlException;

public class java_09842_CredentialValidator_A07 implements java.security.AuthenticationValidator {

    private static final String USER_DB = "dbuser";
    private static final String PASSWORD_DB = "dbpassword";

    @Override
    public boolean validate(Credential credential) {
        String dbUser = credential.getIdentifier();
        String dbPassword = (String) credential.getCredential();

        if (dbUser.equals(USER_DB) && dbPassword.equals(PASSWORD_DB)) {
            return true;
        } else {
            throw new AccessControlException("Access is denied");
        }
    }
}