import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class java_06535_SessionManager_A07 {
    // The key must be 16 bytes (128 bits) for AES
    private static final String KEY = "1234567812345678";

    public static String encrypt(String data) throws Exception {
        Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes()));
    }

    public static String authenticate(String data) throws Exception {
        Key macKey = new SecretKeySpec(KEY.getBytes(), "HMACSHA1");
        Mac mac = Mac.getInstance("HMACSHA1");
        mac.init(macKey);
        byte[] hash = mac.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }

    public static String verify(String data, String signature) throws Exception {
        Key macKey = new SecretKeySpec(KEY.getBytes(), "HMACSHA1");
        Mac mac = Mac.getInstance("HMACSHA1");
        mac.init(macKey);
        byte[] hash = mac.doFinal(data.getBytes());
        return (new String(hash)) .equals(signature) ? "Verified" : "Failed";
    }
}