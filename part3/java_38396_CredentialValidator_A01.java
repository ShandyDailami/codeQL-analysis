import java.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_38396_CredentialValidator_A01 {
    private String plainTextPassword;
    private String encodedPassword;

    public java_38396_CredentialValidator_A01(String password) {
        this.plainTextPassword = password;
    }

    public void encodePassword() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hash = md.digest(plainTextPassword.getBytes());
            encodedPassword = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password123");
        validator.encodePassword();
        System.out.println("Encoded Password: " + validator.getEncodedPassword());
    }
}