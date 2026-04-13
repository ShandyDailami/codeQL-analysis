public class java_09994_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    @Override
    public boolean validate(String username, String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    @Override
    public List<String> getErrors(String username, String password) {
        List<String> errors = new ArrayList<>();
        if (!password.matches(STRONG_PASSWORD_PATTERN)) {
            errors.add("Password should be strong enough (i.e. contain at least one number, one lowercase letter, one uppercase letter, one special character, and should be at least 8 characters long).");
        }
        return errors;
    }
}