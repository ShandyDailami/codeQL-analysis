import java.util.regex.Pattern;

public class java_23078_CredentialValidator_A08 implements CredentialValidator {

    private static final Pattern STRONG_PASSWORD_PATTERN = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$"
    );

    @Override
    public CredentialValidationResult validate(String password) {
        if (password == null) {
            return CredentialValidationResult.createNotValidResult("Password is null");
        }

        if (password.isEmpty()) {
            return CredentialValidationResult.createNotValidResult("Password is empty");
        }

        if (!STRONG_PASSWORD_PATTERN.matcher(password).matches()) {
            return CredentialValidationResult.createNotValidResult("Password is not strong enough");
        }

        return CredentialValidationResult.createValidResult();
    }
}