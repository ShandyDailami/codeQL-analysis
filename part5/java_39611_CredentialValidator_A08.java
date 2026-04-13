import java.security.InvalidParameterException;

public class java_39611_CredentialValidator_A08 {

    public interface CredentialValidator {
        boolean isValid(String username, String password);
    }

    private CredentialValidator validator;

    public java_39611_CredentialValidator_A08(CredentialValidator validator) {
        this.validator = validator;
    }

    public void setValidator(CredentialValidator validator) {
        this.validator = validator;
    }

    public boolean validate(String username, String password) throws InvalidParameterException {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        return validator.isValid(username, password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator(new CredentialValidator() {
            @Override
            public boolean isValid(String username, String password) {
                // This is a placeholder implementation. Replace it with your real logic.
                return username.equals("admin") && password.equals("password");
            }
        });

        try {
            boolean isValid = validator.validate("admin", "password");
            System.out.println("Is valid? " + isValid);
        } catch (InvalidParameterException e) {
            System.out.println("Invalid parameters: " + e.getMessage());
        }
    }
}