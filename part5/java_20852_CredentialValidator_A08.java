import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.management.RuntimeErrorException;

public class java_20852_CredentialValidator_A08 {

    // Stored in plain text for simplicity. In a real-world application, 
    // you would store this in a hashed or encrypted form
    private static final String ADMIN_PASSWORD = "correctpassword";

    // This method is called when the user attempts to log in
    public boolean validate(String passwordAttempt) throws InvalidKeyException, NoSuchAlgorithmException, InvalidParameterSpecException {

        // Create a key and a mac to validate the password
        Key key = new SecretKeySpec("0123456789ABCDEF".getBytes(), "HmacMD5");
        Mac mac = Mac.getInstance(key.getAlgorithm());
        mac.init(key);

        // Validate the password
        byte[] hash = mac.doFinal("password".getBytes());
        if (hash.length != 16) {
            throw new RuntimeErrorException(new RuntimeException("Failed to validate user's password, unexpected hash size."));
        }

        // Compare the password attempt and the stored hash
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
        }
        String storedPassword = sb.toString();
        return storedPassword.equals(passwordAttempt);
    }
}