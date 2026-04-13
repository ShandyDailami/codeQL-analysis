import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_31809_CredentialValidator_A07 implements CredentialValidator {

    private static final String HASH_ALGORITHM = "SHA-256";

    private static byte[] hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        return md.digest(password.getBytes());
    }

    @Override
    public CredentialValidationResult validate(CredentialContext context) {
        String presentedPassword = context.getPassword();
        String persistedPassword = context.getPersistedPassword();

        if (presentedPassword == null || persistedPassword == null) {
            throw new CredentialValidationException("Credentials not available");
        }

        try {
            byte[] presentedPasswordHash = hashPassword(presentedPassword);
            byte[] persistedPasswordHash = hashPassword(persistedPassword);

            if (MessageDigest.isEqual(presentedPasswordHash, persistedPasswordHash)) {
                return CredentialValidationResult.SUCCESS;
            }
        } catch (NoSuchAlgorithmException e) {
            throw new CredentialValidationException("Unable to hash password", e);
        }

        return CredentialValidationResult.FAILURE;
    }
}