import java.security.InvalidParameterException;
import java.util.Base64;

public class java_29752_CredentialValidator_A08 {

    private static final String SALT = "SALT";

    public boolean isValid(String credential, String expectedHash) {
        if (credential == null || expectedHash == null) {
            throw new InvalidParameterException("Credential and expected hash cannot be null");
        }

        String[] parts = expectedHash.split(":");
        if (parts.length != 2) {
            throw new InvalidParameterException("Invalid expected hash format, expected format is username:hash");
        }

        String username = parts[0];
        String expected = parts[1];

        String hash = calculateHash(credential, username, SALT);

        return hash.equals(expected);
    }

    private String calculateHash(String input, String username, String salt) {
        String hash = null;
        try {
            hash = javax.xml.crypto.MessageDigest.getInstance("MD5").digest((input + salt).getBytes("UTF-8"))
                    .toString(Base64.getEncoder());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}