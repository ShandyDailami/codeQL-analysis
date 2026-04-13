public class java_11078_CredentialValidator_A07 implements CredentialValidator {

    private static final Logger logger = LoggerFactory.getLogger(CustomCredentialValidator.class);

    // Pattern to match
    private static final Pattern VALID_PASSWORD_PATTERN = 
        Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");

    @Override
    public CredentialValidationResult validate(CredentialContext context) {
        String password = context.getCredential().getSecret().toString();

        // Check if password matches pattern
        Matcher matcher = VALID_PASSWORD_PATTERN.matcher(password);

        if (matcher.matches()) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failure(new Error(
                    "Invalid password. Password should contain at least one number, one uppercase letter, one lowercase letter, and one special character."));
        }
    }

}