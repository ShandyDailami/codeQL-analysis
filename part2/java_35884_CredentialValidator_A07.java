import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.binary.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class java_35884_CredentialValidator_A07 {

    private static final String HMAC_SHA512_ALGORITHM = "HmacSHA512";

    public boolean validatePassword(String enteredPassword, String hashedPassword, String username) {
        if (StringUtils.isEmpty(enteredPassword) || StringUtils.isEmpty(hashedPassword) || StringUtils.isEmpty(username)) {
            return false;
        }

        try {
            // Create HMAC using the HMAC_SHA512 algorithm
            Mac sha512_HMAC = Mac.getInstance(HMAC_SHA512_ALGORITHM);
            SecretKeySpec secret_key = new SecretKeySpec(hashedPassword.getBytes(StandardCharsets.UTF_8), HMAC_SHA512_ALGORITHM);
            sha512_HMAC.init(secret_key);

            // Generate HMAC for the entered password
            byte[] bytes = sha512_HMAC.doFinal(enteredPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length ; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            String generatedHmac = sb.toString();

            // Check if the entered password matches the hashed password and the generated HMAC
            return hashedPassword.equals(generatedHmac);
        } catch (InvalidKeyException | NoSuchAlgorithmException | StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            return false;
        }
    }
}