public class java_25495_CredentialValidator_A07 implements CredentialValidator {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
    private static final String MEDIUM_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$";
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        System.out.println(validator.validate("test1234")); // true
        System.out.println(validator.validate("test")); // false
    }
}