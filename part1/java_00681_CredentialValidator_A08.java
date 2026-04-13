import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class java_00681_CredentialValidator_A08 {

    private static final String HMAC_SHA512_ALGORITHM = "HMACSHA512";

    public boolean isValidCredential(String credential, String secret) {
        // Extract the username and password from the credential
        String[] parts = credential.split(":");
        if (parts.length != 2) {
            return false;
        }
        String username = parts[0];
        String password = parts[1];

        // Create a HMAC SHA512 with the secret key
        Mac sha512_HMAC = Mac.getInstance(HMAC_SHA512_ALGORITHM);
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), HMAC_SHA512_ALGORITHM);
        sha512_HMAC.init(secret_key);

        // Compute the HMAC and compare it with the provided password
        byte[] passwordBytes = password.getBytes();
        byte[] computedBytes = sha512_HMAC.doFinal(passwordBytes);
        String computedPassword = Base64.getEncoder().encodeToString(computedBytes);

        return computedPassword.equals(parts[1]);
    }
}