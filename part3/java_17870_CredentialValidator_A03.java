import java.util.Base64;
import java.util.zip.DataCoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_17870_CredentialValidator_A03 implements CredentialValidator {

    private MessageDigest messageDigest;

    public java_17870_CredentialValidator_A03() {
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 is not a valid algorithm", e);
        }
    }

    @Override
    public String validate(String arg0) throws InvalidCredentialException {
        if (arg0 == null) {
            throw new InvalidCredentialException("null credentials provided");
        }
        byte[] hash = messageDigest.digest(arg0.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    @Override
    public boolean validate(String arg0, String arg1) throws InvalidCredentialException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean validate(Credential arg0) throws InvalidCredentialException {
        throw new UnsupportedOperationException();
    }
}