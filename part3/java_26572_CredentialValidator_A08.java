import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;

public class java_26572_CredentialValidator_A08 implements CredentialValidator {

    private static final String ALGORITHM = "SHA-1";

    @Override
    public boolean validate(String username, String passwordToValidate) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] thedigest = md.digest(passwordToValidate.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
            }
            String hashedPassword = sb.toString();
            return hashedPassword.equals(username);
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("Unsupported algorithm.");
        } catch (NullPointerException e) {
            throw new InvalidParameterException("Null parameter.");
        }
    }
}