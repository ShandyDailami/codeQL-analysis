import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_25308_CredentialValidator_A01 {

    public boolean validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getCaller();
            char[] password = usernamePasswordCredential.getPassword();

            // Simulate authentication with hardcoded credentials
            if (username != null && username.equals("admin") && password != null && password.length == 4 && password[0] == '1' && password[1] == '2' && password[2] == '3' && password[3] == '4') {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}