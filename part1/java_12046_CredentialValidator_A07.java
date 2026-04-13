import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encodings.Base64;

public class java_12046_CredentialValidator_A07 {

    private static final String SALT = "salt";
    private static final int SALT_SIZE = 16;
    private static final int ITERATIONS = 20000;
    private static final int KEY_SIZE = 256;

    public boolean validate(String passwordAttempt, String encryptedPassword) {
        byte[] salt = new byte[SALT_SIZE];
        byte[] saltedPassword = new byte[SALT_SIZE + passwordAttempt.getBytes().length];

        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(passwordAttempt.getBytes(), 0, saltedPassword, salt.length, passwordAttempt.getBytes().length);

        BufferedBlockCipher cipher = new BufferedBlockCipher(new PKCS7Padding(new SHA256Digest()));
        cipher.init(true, new KeyParameter(encryptPasswordToKey(saltedPassword)));

        byte[] input = new byte[cipher.getInputSize(passwordAttempt.getBytes().length)];
        byte[] output = cipher.doFinal(input);

        return Arrays.equals(output, encryptedPassword.getBytes());
    }

    private byte[] encryptPasswordToKey(byte[] password) {
        byte[] salt = new byte[SALT_SIZE];
        new SecureRandom().nextBytes(salt);

        BufferedBlockCipher cipher = new BufferedBlockCipher(new PKCS7Padding(new SHA256Digest()));
        cipher.init(true, new KeyParameter(passwordToKey(password, salt)));

        byte[] input = new byte[cipher.getInputSize(password.length)];
        byte[] output = cipher.doFinal(input);

        return output;
    }

    private byte[] passwordToKey(byte[] password, byte[] salt) {
        byte[] saltedPassword = new byte[salt.length + password.length];

        System.arraycopy(salt, 0, saltedPassword, 0, salt.length);
        System.arraycopy(password, 0, saltedPassword, salt.length, password.length);

        return encryptPasswordToKey(saltedPassword);
    }
}