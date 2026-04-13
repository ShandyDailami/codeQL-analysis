import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_27677_CredentialValidator_A03 {

    private MessageDigest md;

    public java_27677_CredentialValidator_A03() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public boolean validate(String username, String password) {
        String hashedPassword = hashPassword(password);
        return Arrays.equals(getHashedPassword(username), hashedPassword);
    }

    private byte[] getHashedPassword(String password) {
        return md.digest(password.getBytes());
    }

    private byte[] hashPassword(String password) {
        return md.digest(password.getBytes());
    }
}