import java.security.InvalidParameterException;

public class java_11241_CredentialValidator_A07 {
    public interface CredentialValidator {
        boolean validate(String password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator() {
            @Override
            public boolean validate(String password) {
                if (password == null || password.length() < 8) {
                    throw new InvalidParameterException("Password must be at least 8 characters long");
                }

                if (password.matches(".*\\d.*")) {
                    throw new InvalidParameterException("Password must not contain any numbers");
                }

                if (password.matches(".*[a-z].*")) {
                    throw new InvalidParameterException("Password must not contain any lowercase letters");
                }

                if (password.matches(".*[A-Z].*")) {
                    throw new InvalidParameterException("Password must not contain any uppercase letters");
                }

                if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                    throw new InvalidParameterException("Password must not contain any special characters");
                }

                return true;
            }
        };

        try {
            validator.validate("supersecurepassword");
            System.out.println("Valid password");
        } catch (InvalidParameterException e) {
            System.out.println("Invalid password: " + e.getMessage());
        }
    }
}