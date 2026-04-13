import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_24065_CredentialValidator_A03 {

    public boolean validate(String username, String password) {
        Credential credential = new UsernamePasswordCredential(username, password);

        try {
            javax.security.auth.AuthStatus authStatus = AuthService.login(credential);

            if (authStatus != AuthStatus.SUCCESS) {
                throw new FailedLoginException("Failed to authenticate user: " + authStatus.toString());
            }

            return true;
        } catch (LoginException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.validate("user", "password"));
    }
}