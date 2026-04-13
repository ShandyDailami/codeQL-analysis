public class java_21704_CredentialValidator_A01 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = 
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    private static final Pattern passwordPattern = Pattern.compile(STRONG_PASSWORD_PATTERN);

    @Override
    public ValidationResult validate(String password) {
        if (password == null || password.isEmpty()) {
            return ValidationResult.error("Password is null or empty");
        }

        Matcher matcher = passwordPattern.matcher(password);
        if (!matcher.matches()) {
            return ValidationResult.error("Password does not meet the strong password criteria (contains lower case, upper case, numbers, special characters)");
        }

        return ValidationResult.success();
    }
}