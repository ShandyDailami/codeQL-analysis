import java.security.Credential;
import java.security.InvalidParameterException;
import java.util.Base64;

public class java_21831_CredentialValidator_A07 {

    private static final String USER_ID = "testUser";
    private static final String PASSWORD = "testPassword";

    public boolean validate(Credential credential) {
        if (credential == null) {
            throw new InvalidParameterException("Credential object cannot be null");
        }

        String providedId = credential.getIdentifier();
        String providedPassword = credential.getPassword();

        // Convert password to Base64 to make it secure
        byte[] decodedPassword = Base64.getDecoder().decode(providedPassword);
        String decodedPasswordString = new String(decodedPassword);

        return USER_ID.equals(providedId) && PASSWORD.equals(decodedPasswordString);
    }

}