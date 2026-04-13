import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_34843_CredentialValidator_A08 {
    private String userPassword;

    public java_34843_CredentialValidator_A08(String password) {
        userPassword = password;
    }

    public boolean validate(String passwordAttempt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(passwordAttempt.getBytes());
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < hash.length ;i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            String encryptedAttempt = sb.toString();

            return userPassword.equals(encryptedAttempt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }
}