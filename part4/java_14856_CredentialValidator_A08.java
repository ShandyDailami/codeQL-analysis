import java.util.Base64;
import java.util.UUID;

public class java_14856_CredentialValidator_A08 {

    // A method to check if a given credential is valid.
    public boolean isValid(String credential) {
        // First, decode the credential from Base64.
        byte[] decodedCredential = Base64.getDecoder().decode(credential);

        // Then, decode the decoded credential.
        String decodedString = new String(decodedCredential);

        // Check if the decoded string is not empty.
        // This check is done to ensure the credential is not empty.
        if (decodedString.isEmpty()) {
            return false;
        }

        // Then, check if the decoded string contains a ':' character.
        // This check is done to ensure the credential is in a valid format.
        if (decodedString.contains(":")) {
            // Split the decoded string into username and password.
            String[] split = decodedString.split(":");

            // Check if the split string length is greater than 1.
            // This check is done to ensure the credential is in a valid format.
            if (split.length > 1) {
                // Then, check if the password length is greater than 7.
                // This check is done to ensure the password is not too weak.
                if (split[1].length() > 7) {
                    return true;
                }
            }
        }
        return false;
    }
}