import java.util.Base64;
import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_15585_CredentialValidator_A01 {

    public static boolean validate(String username, String password) {
        // We're using a simple string comparison here for the sake of example.
        // In a real application, you'd have to store the hashed passwords and compare
        // the password provided in plaintext with the hashed version.
        return "user".equals(username) && "password".equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(Credential credential) throws FailedLoginException {
                if (credential instanceof UsernamePasswordCredential) {
                    UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
                    String username = usernamePasswordCredential.getIdentifier();
                    String password = new String(usernamePasswordCredential.getPassword(), "UTF-8");

                    return validate(username, password);
                } else {
                    throw new FailedLoginException("Unsupported credential type: " + credential.getClass().getName());
                }
            }
        };

        // Use the validator
        // In a real application, you'd replace this with your own code to use the validator.
        // For example:
        // Credential credential = validator.validate(new UsernamePasswordCredential("user", "password"));

        // If the validation was successful, the credential object will not be null.
        // Otherwise, it will be null.
        // For example:
        // if (credential != null) {
        //     // Handle the successful login case.
        // } else {
        //     // Handle the failed login case.
        // }
    }
}