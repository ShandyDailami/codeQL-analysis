import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.LoginException;

public class java_01917_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_01917_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void authenticate() throws LoginException, CredentialNotFoundException {
        // This is a simple example of a legacy authentication process.
        // In a real-world application, this would be replaced with a more complex process.
        if (this.username.equals("admin") && this.password.equals("password")) {
            System.out.println("Authentication successful.");
        } else {
            throw new CredentialNotFoundException("Authentication failed.");
        }
    }

    public static void main(String[] args) {
        // In a real-world application, you would not call this from the main method.
        // Instead, you would call it from another class or from the command line.
        try {
            CredentialValidator validator = new CredentialValidator("admin", "password");
            validator.authenticate();
        } catch (LoginException | CredentialNotFoundException e) {
            e.printStackTrace();
        }
    }
}