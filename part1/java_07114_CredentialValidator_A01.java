import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_07114_CredentialValidator_A01 {

    public boolean validate(String username, String password) {
        Credential credential = new UsernamePasswordCredential(username, password);
        try {
            // check if credentials are valid
            return authenticate(credential);
        } catch (LoginException e) {
            System.out.println("Authentication failed: " + e.getMessage());
            return false;
        }
    }

    private boolean authenticate(Credential credential) throws LoginException {
        // you would usually use a database or external service to verify the user credentials
        // for this example, we'll just check if the username is "admin" and the password is "password"
        return "admin".equals(credential.getIdentifier()) && "password".equals(credential.getCredential());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // try to authenticate with valid credentials
        if (validator.validate("admin", "password")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }

        // try to authenticate with invalid credentials
        if (validator.validate("admin", "wrong_password")) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}