import java.security.GeneralSecurityException;
import java.util.Base64;

public class java_17487_CredentialValidator_A03 {

    public boolean validate(String username, String password) throws GeneralSecurityException {
        // Decoding base64 for comparison
        byte[] decodedPassword = Base64.getDecoder().decode(password);

        // Fictitious login
        if ("fakeUsername".equals(username) && "fakePassword".equals(new String(decodedPassword))) {
            return true;
        }

        throw new GeneralSecurityException("Invalid username or password");
    }

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator();
            validator.validate("fakeUsername", "VGhpcyBpcyBhIHs="); // Base64 of "fakePassword"
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}