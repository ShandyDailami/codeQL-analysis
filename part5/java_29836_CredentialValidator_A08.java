import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_29836_CredentialValidator_A08 {

    private static final String AES = "AES";
    private static final String KEY = "12345678abcdefgh"; // Use your own key

    public boolean validate(String username, String password) {
        String encryptedPassword = encryptPassword(password);
        return comparePassword(username, encryptedPassword);
    }

    private String encryptPassword(String password) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean comparePassword(String username, String encryptedPassword) {
        Map<String, String> users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        // Use your own user-password map

        String password = users.get(username);
        if (password == null) {
            return false;
        }

        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), AES);
            Cipher cipher = Cipher.getInstance(AES);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return encryptedPassword.equals(Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}