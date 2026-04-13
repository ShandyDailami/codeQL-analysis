import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class java_02564_CredentialValidator_A07 {
    private static final String ALGORITHM = "AES";
    private SecretKey key;

    public java_02564_CredentialValidator_A07() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(128); // AES works with 128 bit keys
        this.key = keyGenerator.generateKey();
    }

    public void setKey(SecretKey key) {
        this.key = key;
    }

    public SecretKey getKey() {
        return key;
    }

    public UserCredentials createCredentials(String username, String password) throws Exception {
        // AES requires a 16, 24, or 32 byte secret key. We'll use 16 bytes for simplicity.
        byte[] bytes = password.getBytes();
        return new UserCredentials(encrypt(bytes), encrypt(username.getBytes()), encrypt(Hex.encodeHexString(this.key.getEncoded())));
    }

    public boolean validate(UserCredentials credentials) throws Exception {
        byte[] bytes = encrypt(credentials.getPassword());
        boolean success = Arrays.equals(bytes, this.key.getEncoded());
        if (success) {
            bytes = encrypt(credentials.getUsername().getBytes());
            success = Arrays.equals(bytes, this.key.getEncoded());
        }
        if (success) {
            byte[] keyBytes = Hex.decodeHex(credentials.getKey());
            SecretKey key = new SecretKeySpec(keyBytes, 0, keyBytes.length, ALGORITHM);
            setKey(key);
            success = Arrays.equals(bytes, this.key.getEncoded());
        }
        return success;
    }

    private byte[] encrypt(byte[] bytes) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, this.key);
        return cipher.doFinal(bytes);
    }

    public static void main(String[] args) throws Exception {
        CredentialValidator validator = new CredentialValidator();
        UserCredentials credentials = validator.createCredentials("user", "password");
        System.out.println(credentials);

        boolean valid = validator.validate(credentials);
        System.out.println("Is valid: " + valid);
    }
}