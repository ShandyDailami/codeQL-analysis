import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_09194_CredentialValidator_A07 {

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator() {
                @Override
                public CredentialValidationResult validate(Credential credential) throws FailedLoginException {
                    String username = credential.getIdentifier();
                    char[] password = (char[]) credential.getCredential();

                    // Simulate a legacy authentication process
                    // In reality, this would likely involve checking a database for a valid username/password combination
                    if ("admin".equals(username) && "password".equals(new String(password))) {
                        return new CredentialValidationResult("Success", null, null);
                    } else {
                        return new CredentialValidationResult("Failure", null, null);
                    }
                }
            };

            // Simulate a login attempt
            if (validator.validate(new UsernamePasswordCredential("admin", "password".toCharArray()))) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}