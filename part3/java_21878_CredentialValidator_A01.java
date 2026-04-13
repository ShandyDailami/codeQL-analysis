import javax.naming.AuthenticationException;
import javax.naming.NamingException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_21878_CredentialValidator_A01 {

    public void validate(String username, String password) throws CredentialNotFoundException, LoginException, NamingException, AuthenticationException {
        // Assume we are using the standard library's Credentials and LoginContext
        // for this example
        javax.security.auth.Credentials creds = new javax.security.auth.UsernamePasswordCredentials(username, password);
        javax.security.auth.LoginContext loginContext = new javax.security.auth.LoginContext("MyRealm");
        loginContext.validate(creds);

        if (loginContext.getSubject() == null) {
            throw new CredentialNotFoundException("Credentials not found");
        }

        if (!loginContext.getSubject().getPrincipal().toString().equals(username)) {
            throw new AuthenticationException("Authentication failed");
        }

        System.out.println("Authentication successful");
    }
}