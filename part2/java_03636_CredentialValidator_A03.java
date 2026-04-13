import javax.security.auth.Subject;
import java.security.AuthPermission;
import java.security.Permission;
import java.security.Policy;

public class java_03636_CredentialValidator_A03 {
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validatePassword("Test@123"));
    }
}