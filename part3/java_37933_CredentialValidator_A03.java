import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_37933_CredentialValidator_A03 {
    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public boolean validate(Credential credential) throws FailedLoginException {
        if (!(credential instanceof UsernamePasswordCredential)) {
            throw new FailedLoginException("Invalid credential type");
        }

        UsernamePasswordCredential usernamePasswordCredential = (UsernamePasswordCredential) credential;
        String username = usernamePasswordCredential.getIdentifier();
        String password = new String(usernamePasswordCredential.getPassword());

        if (username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD)) {
            return true;
        } else {
            throw new FailedLoginException("Invalid credentials");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        UsernamePasswordCredential credential = new UsernamePasswordCredential("admin", "password".toCharArray());

        try {
            if (validator.validate(credential)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } catch (FailedLoginException e) {
            System.out.println("Failed to login: " + e.getMessage());
        }
    }
}