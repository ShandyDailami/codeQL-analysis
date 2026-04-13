import java.security.Authenticator;
import java.security.PasswordAuthentication;
import java.security.auth.Authenticator;
import java.security.auth.UsernamePasswordAuthentication;

public class java_20032_CredentialValidator_A01 implements Authenticator {

    private String username;
    private char[] password;

    public java_20032_CredentialValidator_A01(String username, char[] password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication() {
        return new UsernamePasswordAuthentication(username, password);
    }

    public static void main(String[] args) {
        String username = "user";
        char[] password = 'password'.toCharArray();

        Authenticator authenticator = new CustomAuthenticator(username, password);
        PasswordAuthentication authentication = authenticator.getPasswordAuthentication();

        // Now we have the authentication, we can use it to authenticate ourselves
        if (authentication.getResult() == PasswordAuthentication.authenticateOnly(authentication.getPrivileged(), authentication.getPrompt())) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed.");
        }
    }
}