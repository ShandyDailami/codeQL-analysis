import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_04482_CredentialValidator_A03 {

    public boolean validate(Credential credential) {
        if (credential instanceof UsernamePasswordCredential) {
            UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
            String username = usernamePasswordCredential.getCaller();

            // You can add more complex pattern matching logic here
            // For now, let's just check if the username starts with 'admin'
            return username.startsWith("admin");
        }

        return false;
    }
}