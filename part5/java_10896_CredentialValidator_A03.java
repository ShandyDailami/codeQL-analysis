import java.util.Base64;

public class java_10896_CredentialValidator_A03 {
    private String userPassword;
    private String encryptedPassword;

    public java_10896_CredentialValidator_A03(String password) {
        this.userPassword = password;
        this.encryptedPassword = encryptPassword(password);
    }

    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean validateCredentials(String password) {
        return this.encryptPassword(password).equals(this.encryptedPassword);
    }
}