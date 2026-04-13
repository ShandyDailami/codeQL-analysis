public class java_24965_CredentialValidator_A08 implements CredentialValidator {

    private static final String VALID_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(String username, String password) {
        // validate password against pattern
        if (!password.matches(VALID_PASSWORD_PATTERN)) {
            System.out.println("Invalid password. Password should contain at least one numeric character, one uppercase character, one lowercase character, one special character, and should be at least 8 characters long.");
            return false;
        }

        // if password passes validation, return true
        return true;
    }
}