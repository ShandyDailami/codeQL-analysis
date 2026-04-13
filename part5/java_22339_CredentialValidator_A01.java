import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_22339_CredentialValidator_A01 implements CredentialValidator {

    private String[] allowedUsernames = {"user1", "user2", "admin"};
    private String[] allowedPasswords = {"password1", "password2", "admin"};

    @Override
    public UsernamePasswordCredential validate(UsernamePasswordCredential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        for (String allowedUsername : allowedUsernames) {
            if (allowedUsername.equals(username)) {
                for (String allowedPassword : allowedPasswords) {
                    if (allowedPassword.equals(password)) {
                        return new UsernamePasswordCredential(username, password);
                    }
                }
            }
        }

        // If no match is found, LoginException is thrown with an error message
        throw new LoginException("Invalid username or password.");
    }
}