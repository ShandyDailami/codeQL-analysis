import javax.security.auth.login.LoginException;
import javax.security.auth.password.PasswordChangeException;
import javax.security.auth.password.PasswordValidator;
import javax.security.auth.password.PasswordRequestor;
import javax.security.auth.password.PasswordState;
import javax.security.auth.password.UnsupportedPasswordException;

public class java_31252_CredentialValidator_A08 implements PasswordValidator, PasswordRequestor {

    private String password;

    public java_31252_CredentialValidator_A08(String password) {
        this.password = password;
    }

    @Override
    public PasswordState validate(String arg0) throws UnsupportedPasswordException {
        // This method should validate the password.
        // If the password is incorrect, throw UnsupportedPasswordException.
        // If the password is correct, return PasswordState.VALID.
        if (arg0.equals(this.password)) {
            return PasswordState.VALID;
        } else {
            throw new UnsupportedPasswordException("Invalid password");
        }
    }

    @Override
    public String requestPasswordChange(String arg0) throws PasswordChangeException {
        // This method should ask for a password change.
        // If the password is incorrect, throw PasswordChangeException.
        // If the password is correct, return the new password.
        if (arg0.equals(this.password)) {
            return "newpassword";
        } else {
            throw new PasswordChangeException("Password change failed");
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Create a new MyPasswordValidator
        MyPasswordValidator validator = new MyPasswordValidator("password");
        
        try {
            // Use the validator
            validator.validate("password"); // This should work fine
            String newPassword = validator.requestPasswordChange("password"); // This should fail
        } catch (LoginException | PasswordChangeException e) {
            e.printStackTrace();
        }
    }
}