import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_40673_CredentialValidator_A01 implements javax.security.auth.CredentialValidator {

    private UserService userService;

    public java_40673_CredentialValidator_A01(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Credential validate(Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getPassword();

        User user = userService.findUserByUsername(username);

        // If the user does not exist, throw a LoginException
        if (user == null) {
            throw new LoginException("Invalid username or password");
        }

        // If the password is incorrect, throw a LoginException
        if (!user.getPassword().equals(password)) {
            throw new LoginException("Invalid username or password");
        }

        // If everything is correct, return the credential
        return new UsernamePasswordCredential(username, password);
    }
}