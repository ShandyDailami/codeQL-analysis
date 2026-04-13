import java.security.InvalidParameterException;
import java.util.Base64;

public class java_20910_CredentialValidator_A08 {

    public boolean validate(String credential) {
        try {
            // Decode the base64 credential
            String decodedCredential = new String(Base64.getDecoder().decode(credential));

            // Split the credential into username and password
            String[] credentialParts = decodedCredential.split(":");

            if (credentialParts.length != 2) {
                throw new InvalidParameterException("Invalid credential format. Expected format is USERNAME:PASSWORD");
            }

            String username = credentialParts[0];
            String password = credentialParts[1];

            // Here you would typically check if the username and password are valid,
            // and also check if the password is secure (i.e., not easily guessable).

            // For this example, we'll just return true. In a real application,
            // you'd typically return a boolean indicating whether the credential
            // is valid.
            return true;
        } catch (Exception e) {
            // If the credential is not valid, return false.
            return false;
        }
    }
}