public class java_41138_CredentialValidator_A08 implements CredentialValidator {

    // A password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, and one digit.
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(Credential credential) throws CredentialValidationException {
        String password = credential.getPassword();
        if (!password.matches(PASSWORD_PATTERN)) {
            throw new CredentialValidationException("Invalid password");
        }
        return true;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        try {
            validator.validate(new Credential("password"));
            System.out.println("Password is valid");
        } catch (CredentialValidationException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}