import java.security.auth.Credential;
import java.security.auth.UsernamePasswordCredentials;
import java.security.auth.login.LoginContext;
import java.security.auth.login.LoginException;

public class java_40979_CredentialValidator_A07 {

    public static void main(String[] args) {
        // Create a credential using a dummy user and password
        Credential cred = new UsernamePasswordCredentials("user", "password");

        // Create a login context with our credential
        LoginContext loginContext = new LoginContext("Realm", cred);

        // Try to log in
        try {
            loginContext.login();
            System.out.println("Login successful!");
        } catch (LoginException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
    }
}