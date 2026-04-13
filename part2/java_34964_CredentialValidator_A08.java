import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_34964_CredentialValidator_A08 {

    private String username;
    private String password;
    private String expectedUsername;
    private String expectedPassword;

    public java_34964_CredentialValidator_A08(String username, String password, String expectedUsername, String expectedPassword) {
        this.username = username;
        this.password = this.md5(password);
        this.expectedUsername = expectedUsername;
        this.expectedPassword = this.md5(expectedPassword);
    }

    private String md5(String str) {
        MessageDigest messageDigest;
        byte[] bytes;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            bytes = messageDigest.digest(str.getBytes());
            for (int i = 0; i < bytes.length; i++) {
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public boolean isValid() {
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "pass", "user", "pass");
        System.out.println(validator.isValid()); // prints true
    }
}