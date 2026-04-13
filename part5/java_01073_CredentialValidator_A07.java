import javax.security.auth.CredentialValidator;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_01073_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // Here you can add logic to verify if the username and password are correct
        // For now, let's just return the same credential object

        if ("admin".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password);
        }

        // If credentials are not correct, throw a LoginException
        throw new LoginException("Invalid username or password");
    }
}