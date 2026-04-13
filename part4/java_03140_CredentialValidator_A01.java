import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.validator.PasswordValidator;

public class java_03140_CredentialValidator_A01 {

    public boolean validateCredentials(String userName, String password) {
        PasswordValidator passwordValidator = new PasswordValidator();

        // Check if password matches a pattern (for example, a password of 8 characters or more)
        if (!passwordValidator.isPasswordValid(password, 8, null)) {
            return false;
        }

        // Check if password contains a certain sequence (for example, a sequence of uppercase letters)
        if (!passwordValidator.isPasswordValid(password, 2, ".*[A-Z].*")) {
            return false;
        }

        // Check if password is not a commonly used password
        if (isCommonPassword(password)) {
            return false;
        }

        return true;
    }

    private boolean isCommonPassword(String password) {
        String commonPasswords[] = { "password", "admin", "root", "12345678", "11111111" };

        for (String s : commonPasswords) {
            if (s.equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validateCredentials("user", "password"));
    }
}