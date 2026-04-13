import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.nio.charset.StandardCharsets;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

public class java_10402_CredentialValidator_A07 implements CredentialValidator {

    private static final String SHA256 = "SHA-256";

    @Override
    public CredentialValidationResult validate(Credential credential) throws LoginException {
        String username = credential.getCredentialIdentifier();
        String password = new String(credential.getCredential(), StandardCharsets.UTF_8);

        // Perform password hashing using SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance(SHA256);
            byte[] hash = md.digest(password.getBytes());

            // Convert hash to hexadecimal and store it in password field
            String hashedPassword = bytesToHex(hash);

            // Validate the username and password
            if (username.equals("admin") && hashedPassword.equals("a3b9c4d48c7a45c9b82f6e99f0769c18")) {
                return new CredentialValidationResult("Success", null);
            } else {
                return new CredentialValidationResult("Failure", null);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new InvalidParameterException("Unable to find SHA-256 algorithm", e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}