import com.example.encryption.HashedPasswordEncryptor;
import com.example.validation.CredentialValidator;

public class java_38125_CredentialValidator_A08 {

    private HashedPasswordEncryptor passwordEncryptor;
    private CredentialValidator validator;

    public java_38125_CredentialValidator_A08(HashedPasswordEncryptor passwordEncryptor, CredentialValidator validator) {
        this.passwordEncryptor = passwordEncryptor;
        this.validator = validator;
    }

    public boolean validateCredentials(String username, String password) {
        // Encrypt the password
        String encryptedPassword = passwordEncryptor.encrypt(password);

        // Validate the credentials
        return validator.validate(username, encryptedPassword);
    }
}