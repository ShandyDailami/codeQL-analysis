import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_12430_CredentialValidator_A08 {
    private static final String KEY = "A08_IntegrityFailure";

    public static void main(String[] args) throws Exception {
        String password = "password";
        String encryptedPassword = encryptPassword(password);

        System.out.println("Encrypted Password: " + encryptedPassword);

        String enteredPassword = "enteredPassword";
        if (validatePassword(encryptedPassword, enteredPassword)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }

    private static String encryptPassword(String password) {
        SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes()));
    }

    private static boolean validatePassword(String encryptedPassword, String enteredPassword) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(KEY.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return encryptedPassword.equals(Base64.getEncoder().encodeToString(cipher.doFinal(enteredPassword.getBytes())));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}