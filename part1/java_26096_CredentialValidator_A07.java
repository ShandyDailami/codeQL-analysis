import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;
import javax.security.auth.usernamePasswordAuthentication.UnknownUserException;
import javax.security.auth.usernamePasswordAuthentication.UserPrincipal;

public class java_26096_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public UserPrincipal validate(javax.security.auth.login.LoginContext loginContext) throws LoginException {
        // Get the user name and password from the login context
        String userName = loginContext.getCallerPrincipal().getName();
        String password = new String(loginContext.getCallerPrincipal().getPassword());

        // Here, we are only checking if the username is "user" and the password is "password".
        // In real-world scenarios, you would want to compare the credentials with a database.
        if ("user".equals(userName) && "password".equals(password)) {
            return new UserPrincipal(userName);
        } else {
            throw new UnknownUserException();
        }
    }
}