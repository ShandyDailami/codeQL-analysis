import java.util.Base64;
import java.util.Optional;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class java_07095_CredentialValidator_A07 {

    private static final String AES = "AES";
    private static final String KEY = "12345678abcdefgh"; // 32 bytes = 44 bytes
    private static final String INIT_VECTOR = "1234567887654321"; // 16 bytes = 24 bytes

    private Cipher cipher;
    private IvParameterSpec ivParameterSpec;
    private SecretKeySpec secretKeySpec;

    public java_07095_CredentialValidator_A07() throws Exception {
        this.cipher = Cipher.getInstance(AES);
        this.ivParameterSpec = new IvParameterSpec(INIT_VECTOR.getBytes());
        this.secretKeySpec = new SecretKeySpec(KEY.getBytes(), AES);
        this.cipher.init(Cipher.ENCRYPT_MODE, this.secretKeySpec, this.ivParameterSpec);
    }

    public Optional<String> encrypt(String data) {
        try {
            byte[] encrypted = this.cipher.doFinal(data.getBytes("UTF-8"));
            return Optional.of(Base64.getEncoder().encodeToString(encrypted));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<String> decrypt(String encryptedData) {
        try {
            byte[] decrypted = this.cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return Optional.of(new String(decrypted, "UTF-8"));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}