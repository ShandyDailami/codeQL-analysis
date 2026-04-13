import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;
import java.util.Arrays;
import java.util.Base64;

public class java_32171_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public String getCallerPrincipal() {
        return "secured";
    }

    @Override
    public String getPassword() {
        return "secured";
    }

    @Override
    public boolean validate(String caller, String password) throws CredentialException, InvalidCredentialException {
        if (caller == null || password == null) {
            throw new InvalidCredentialException("Caller or password is null");
        }

        if ("secured".equals(caller) && "secured".equals(password)) {
            return true;
        } else {
            throw new InvalidCredentialException("Invalid caller or password");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new SecureCredentialValidator();

        try {
            validator.validate("secured", "secured");
            System.out.println("Validated successfully");
        } catch (Exception e) {
            System.out.println("Failed to validate: " + e.getMessage());
        }
    }
}