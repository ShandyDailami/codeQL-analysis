import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class java_18322_CredentialValidator_A01 implements LoginModule {

    @Override
    public Credential authenticate(Credential c) throws LoginException {
        String username = c.getCaller();
        String password = c.getPasswordAsString();
        
        // Compare the username and password with the hard-coded ones
        if ("admin".equals(username) && "password".equals(password)) {
            return new UsernamePasswordCredential(username, password);
        } else {
            throw new LoginException("Invalid credentials");
        }
    }

    @Override
    public boolean validate(Credential c) throws LoginException {
        return authenticate(c) != null;
    }
}