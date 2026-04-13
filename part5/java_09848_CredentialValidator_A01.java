import java.security.InvalidParameterException;
import java.util.Base64;

public class java_09848_CredentialValidator_A01 {

    // The CredentialValidator interface requires a method named validateCredentials
    // This method requires a String parameter called credentials
    public boolean validateCredentials(String credentials) {
        // Check if the parameter is null or empty
        if (credentials == null || credentials.isEmpty()) {
            throw new InvalidParameterException("Credentials cannot be null or empty");
        }

        // Decode the credentials string
        String decodedCredentials = new String(Base64.getDecoder().decode(credentials));

        // Split the decoded credentials string into userName and password
        String[] userCredentials = decodedCredentials.split(":");

        if (userCredentials.length != 2) {
            throw new InvalidParameterException("Invalid credentials format. Expected format is USERNAME:PASSWORD");
        }

        // Assume the username is "admin" and password is "password".
        // In reality, you would need to check the credentials against the database
        // or other security system
        return "admin".equals(userCredentials[0]) && "password".equals(userCredentials[1]);
    }
}