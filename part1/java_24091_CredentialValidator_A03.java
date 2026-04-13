import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.UUID;

public class java_24091_CredentialValidator_A03 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/CBC/PKCS5Padding";

    private final SecretKeySpec secretKey;
    private final IvParameterSpec ivParameterSpec;

    public java_24091_CredentialValidator_A03(String secretKey) {
        this.secretKey = new SecretKeySpec(secretKey.getBytes(), ALGORITHM);
        this.ivParameterSpec = new IvParameterSpec(secretKey.getBytes());
    }

    public String encryptPassword(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA256");
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] digestBytes = md.digest(passwordBytes);
        return Base64.getEncoder().encodeToString(digestBytes);
    }

    public String generateSignature(String data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA256");
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);
        byte[] digestBytes = md.digest(dataBytes);
        return Base64.getEncoder().encodeToString(digestBytes);
    }

    public String encryptAndSign(String password, String data) throws Exception {
        String encryptedPassword = encryptPassword(password);
        String encryptedData = encryptData(data);
        String signature = generateSignature(encryptedData);

        return encryptedPassword + ":" + encryptedData + ":" + signature;
    }

    public boolean validate(String encryptedPassword, String encryptedData, String signature, String data) throws Exception {
        String decryptedSignature = decryptSignature(signature);
        boolean isValid = decryptedSignature.equals(generateSignature(encryptedData));

        if (isValid) {
            isValid = decryptedPassword.equals(decryptPassword(encryptedPassword));
        }

        return isValid;
    }

    public static void main(String[] args) throws Exception {
        LegacyCredentialValidator validator = new LegacyCredentialValidator("your_secret_key");
        String password = "strong_password";
        String data = "data_to_sign";

        String encryptedPassword = validator.encryptPassword(password);
        String encryptedData = validator.encryptData(data);
        String signature = validator.generateSignature(encryptedData);

        String encryptedCredentials = validator.encryptAndSign(encryptedPassword, encryptedData, signature, data);

        boolean isValid = validator.validate(encryptedPassword, encryptedData, signature, data);

        System.out.println("Is valid: " + isValid);
    }
}