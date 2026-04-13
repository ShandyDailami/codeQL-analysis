import javax.security.auth.Subject;
import javax.security.auth.password.PasswordChangeAllowed;
import javax.security.auth.password.PasswordChangeNotAllowedException;
import javax.security.auth.password.PasswordVerifier;
import javax.security.auth.password.UsernamePasswordToken;
import java.security.InvalidParameterException;

public class java_41730_CredentialValidator_A08 implements CredentialValidator {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    @Override
    public boolean validate(Subject subject, UsernamePasswordToken token) throws InvalidParameterException {
        String username = token.getIdentifier();
        String password = token.getPassword();

        // Verify that the provided username and password match the expected values
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return true;
        } else {
            throw new InvalidParameterException("Invalid username or password");
        }
    }

    @Override
    public boolean getPasswordRequired() {
        // The PasswordRequired property of the CredentialValidator can be set to true
        // to indicate that a password is required.
        return false;
    }

    @Override
    public boolean enablePassword(String passwordCurrent) throws PasswordNotAllowedException {
        // If password is not allowed, throw a PasswordNotAllowedException
        throw new PasswordNotAllowedException("Password change is not allowed");
    }

    @Override
    public boolean modifyPassword(String oldPassword, String newPassword) throws PasswordNotAllowedException, PasswordNotAllowedException {
        // If password change is not allowed, throw a PasswordNotAllowedException
        throw new PasswordNotAllowedException("Password change is not allowed");
    }

    @Override
    public PasswordVerifier getPasswordVerifier() {
        // Return a PasswordVerifier that will be used to verify the password
        return new PasswordVerifier() {
            @Override
            public String generatePassword(CharSequence s) {
                // This method is not used in this example
                return null;
            }

            @Override
            public boolean validate(CharSequence s) {
                // This method is not used in this example
                return false;
            }
        };
    }
}