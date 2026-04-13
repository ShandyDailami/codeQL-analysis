import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.LoginException;

public class java_33068_CredentialValidator_A03 {

    public CredentialValidatorResult validate(Credential credential) {
        String username = credential.getIdentifier();
        String password = credential.getCredentialIdentifier();

        if ("admin".equals(username) && "password".equals(password)) {
            return new CredentialValidatorResult("Successful authentication", null);
        } else {
            return new CredentialValidatorResult("Invalid credentials", null);
        }
    }

    public static void main(String[] args) throws LoginException {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        // Username and password to authenticate
        String username = "admin";
        String password = "password";

        // Create credential object
        Credential credential = new UsernamePasswordCredential(username, password);

        // Authenticate
        CredentialValidatorResult result = validator.validate(credential);

        if (result.getState().equals("Successful authentication")) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}