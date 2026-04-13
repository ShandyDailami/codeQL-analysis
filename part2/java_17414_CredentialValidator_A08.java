import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PasswordAuthentication;
import java.util.Base64;

public class java_17414_CredentialValidator_A08 implements CredentialValidator {

    private MessageDigest md;

    public java_17414_CredentialValidator_A08() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            // handle exception here
        }
    }

    @Override
    public PasswordAuthentication validate(String arg0, String arg1) {
        byte[] hashedPassword = md.digest(arg1.getBytes());
        String encodedPassword = Base64.getEncoder().encodeToString(hashedPassword);

        return new PasswordAuthentication(arg0, encodedPassword.toCharArray());
    }
}