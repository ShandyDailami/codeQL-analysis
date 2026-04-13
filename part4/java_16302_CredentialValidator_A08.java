import java.util.Base64;
import java.util.UUID;

public class java_16302_CredentialValidator_A08 {
    // A simple CredentialValidator
    // It uses UUIDs for identification and Base64 for encryption
    // It also provides a method for checking the validity of a password

    private static final String SALT = "salt";

    private String id;
    private String encryptedPassword;

    public java_16302_CredentialValidator_A08(String id, String password) {
        this.id = id;
        setPassword(password);
    }

    public void setPassword(String password) {
        this.encryptedPassword = encryptPassword(password);
    }

    public boolean checkPassword(String password) {
        return this.encryptedPassword.equals(encryptPassword(password));
    }

    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString((password + SALT).getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator cv = new CredentialValidator(UUID.randomUUID().toString(), "password");
        System.out.println(cv.checkPassword("wrongpassword")); // False
        System.out.println(cv.checkPassword("password")); // True
    }
}