import java.security.Principal;

public class java_28879_CredentialValidator_A03 {

    // This method will validate a username and password.
    public boolean validate(String username, String password) {
        // This is a very simple example of a password validation.
        // In a real-world application, you would probably want to store the hashed passwords
        // and compare the hashed input to the stored password, not the plaintext password.
        return username.equals("admin") && password.equals("password");
    }

    // This method will return the user's name if the provided username and password are valid.
    public Principal validate(String username, String password, PrincipalContext context) {
        if (validate(username, password)) {
            return context.getPrincipal();
        } else {
            return null;
        }
    }
}