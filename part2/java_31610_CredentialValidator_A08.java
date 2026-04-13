public class java_31610_CredentialValidator_A08 implements CredentialValidator {

    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    @Override
    public boolean isValid(String password, User user) {
        return password.matches(WEAK_PASSWORD_PATTERN);
    }

    @Override
    public String getErrorMessage() {
        return "Password is not strong enough. Password should be at least 8 characters long and contain at least one lower case letter, one upper case letter and one digit.";
    }
}