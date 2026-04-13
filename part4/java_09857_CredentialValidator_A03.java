import java.security.InvalidParameterException;
import java.security.GeneralSecurityException;
import java.util.Base64;

public class java_09857_CredentialValidator_A03 {

    public void validateCredentials(String user, String password) throws InvalidParameterException, GeneralSecurityException {
        if (user == null || password == null) {
            throw new InvalidParameterException("User and password parameters cannot be null");
        }

        String decodedPassword = new String(Base64.getDecoder().decode(password));

        // We're assuming we have a method validatePassword(String user, String password) in our CredentialValidator
        // that checks if the provided password matches our expected password.
        // If the passwords do not match, we throw a GeneralSecurityException
        if (!validatePassword(user, decodedPassword)) {
            throw new GeneralSecurityException("Invalid password for user: " + user);
        }
    }

    // This is a placeholder for the method we assume is available in CredentialValidator
    private boolean validatePassword(String user, String password) {
        // You would replace this with your actual password validation logic here
        // For the sake of simplicity, let's just return true/false for now
        return user.equals("admin") && password.equals("password");
    }
}