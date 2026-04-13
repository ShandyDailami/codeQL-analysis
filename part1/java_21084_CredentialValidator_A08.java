import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptorBasic;

public class java_21084_CredentialValidator_A08 {
    private PasswordEncryptor passwordEncryptor;

    public java_21084_CredentialValidator_A08() {
        passwordEncryptor = new PasswordEncryptorBasic();
    }

    public boolean validateCredentials(String encryptedPassword, String providedPassword) {
        return passwordEncryptor.matches(providedPassword, encryptedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String encryptedPassword = validator.encryptPassword("password123");
        System.out.println("Encrypted Password: " + encryptedPassword);

        boolean isValid = validator.validateCredentials(encryptedPassword, "password123");
        System.out.println("Is Valid: " + isValid);
    }
}