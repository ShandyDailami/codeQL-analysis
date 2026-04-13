import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class java_30557_CredentialValidator_A08 {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = ALGORITHM + "/ECB/NoPadding";
    private static final SecretKeySpec KEY = new SecretKeySpec("ThisIsASecretKey".getBytes(), ALGORITHM);

    public boolean isValid(PublicKey publicKey, String data, String signatureBase64) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] signatureBytes = Base64.getDecoder().decode(signatureBase64);

        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initVerify(publicKey);
        signature.verify(signatureBytes);

        return signature.verify(signatureBytes);
    }

    public String sign(PublicKey publicKey, String data) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        byte[] signatureBytes = new byte[0];

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, KEY);

        byte[] dataBytes = data.getBytes();
        signatureBytes = cipher.doFinal(dataBytes);

        return Base64.getEncoder().encodeToString(signatureBytes);
    }
}