import javax.security.auth.callback.*;
import java.security.AccessControlException;
import java.security.AccessControlListener;
import java.security.Guard;
import java.security.Guardian;
import java.security.GuardianNotRespondingException;

public class java_01365_CredentialValidator_A08 implements CredentialValidator {

    private final Guardian guardian;

    public java_01365_CredentialValidator_A08(Guardian guardian) {
        this.guardian = guardian;
    }

    @Override
    public boolean validate(Credential credential) {
        String password = credential.getPassword();
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters long");
        }

        if (!password.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one number");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }

        return true;
    }

    public static void main(String[] args) {
        // You can use this method to create a Guardian object
        // Guardian guardian = new Guardian();

        // CustomCredentialValidator validator = new CustomCredentialValidator(guardian);

        // // Password validation
        // boolean isValid = validator.validate(new MyCredential("password"));

        // System.out.println("Is password valid? " + isValid);
    }
}