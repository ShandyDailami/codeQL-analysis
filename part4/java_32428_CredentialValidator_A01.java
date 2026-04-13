import java.security.InvalidParameterException;
import java.security.AuthenticationException;
import java.util.Base64;

public class java_32428_CredentialValidator_A01 {

    // In a real-world application, this would be a more complex comparison method
    // that includes hashing the passwords, using stronger encryption, etc.
    public boolean validateCredentials(String username, String password) throws AuthenticationException {
        // This is a simplistic comparison. In a real-world application, 
        // you would use hashing and stronger encryption to compare the passwords.
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password must not be null");
        }

        // Decode the base64 encoded username and password for comparison
        String decodedUsername = new String(Base64.getDecoder().decode(username));
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // Here we're just checking the equality of the decoded strings.
        // In a real-world application, you'd use a secure comparison method here.
        if (decodedUsername.equals("admin") && decodedPassword.equals("password")) {
            return true;
        } else {
            throw new AuthenticationException("Invalid username or password");
        }
    }
}