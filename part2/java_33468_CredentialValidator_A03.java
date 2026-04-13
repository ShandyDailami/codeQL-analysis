import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class java_33468_CredentialValidator_A03 implements CredentialValidator {

    private static final String SECRET_KEY = "A03_Injection";
    private static final int SECRET_KEY_LENGTH = 8;
    private static final String ALGORITHM = "AES";

    @Override
    public boolean validate(Credential credential) {
        String username = credential.getUsername();
        String password = credential.getPassword();

        // AES encryption
        String encryptedPassword = encryptPassword(password);

        // Compare encrypted password with secret key
        if (encryptedPassword.equals(SECRET_KEY)) {
            return true;
        }

        return false;
    }

    private String encryptPassword(String password) {
        byte[] keyBytes = SECRET_KEY.getBytes();
        byte[] passwordBytes = password.getBytes();

        Encoder encoder = Base64.getEncoder();

        // AES encryption
        byte[] encryptedBytes = encoder.encode(passwordBytes);

        return new String(encryptedBytes);
    }
}