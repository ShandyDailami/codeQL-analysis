import java.util.Base64;
import java.util.regex.Pattern;

import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;

public class java_29121_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public String validate(String arg0) throws InvalidCredentialException {

        // Check if the password is null or empty
        if (arg0 == null || arg0.trim().isEmpty()) {
            throw new InvalidCredentialException("Password can't be null or empty");
        }

        // Check if the password is at least 8 characters long and contains at least one uppercase letter, one lowercase letter, and one special character
        if (!Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$", arg0)) {
            throw new InvalidCredentialException("Password should be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one special character");
        }

        // Check if the password is a valid base64 string
        if (!Base64.getDecoder().decode(arg0).toString().equals(arg0)) {
            throw new InvalidCredentialException("Password should be a valid base64 string");
        }

        return null; // Success
    }

    @Override
    public boolean validate(CredentialCredential credentialCredential) throws InvalidCredentialException {
        return validate(credentialCredential.getPassword());
    }

    public static void main(String[] args) {
        CustomValidator validator = new CustomValidator();
        try {
            validator.validate("myPassword@123");
            System.out.println("Password is valid");
        } catch (InvalidCredentialException e) {
            System.out.println(e.getMessage());
        }
    }
}