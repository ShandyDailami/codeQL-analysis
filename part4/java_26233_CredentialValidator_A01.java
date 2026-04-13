import javax.security.auth.Credential;
import javax.security.auth.UsernamePasswordCredential;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class java_26233_CredentialValidator_A01 {

    public java_26233_CredentialValidator_A01() {
        // constructor
    }

    public void validateCredentials(String userName, String password) {
        try {
            Credential credential = new UsernamePasswordCredential(userName, password);
            javax.security.auth.AuthPermission perm = new javax.security.auth.AuthPermission("view");
            credential.setCredential(credential);
            if (credential.getRequestingPrincipal() == null) {
                throw new FailedLoginException("Invalid username or password");
            }
            System.out.println("User " + credential.getRequestingPrincipal().getName() + " authenticated successfully.");
        } catch (LoginException e) {
            System.out.println("Failed to authenticate user: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validateCredentials("admin", "password");
    }
}