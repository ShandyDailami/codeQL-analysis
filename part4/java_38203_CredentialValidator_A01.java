public class java_38203_CredentialValidator_A01 implements CredentialValidator {

    private static final Logger logger = LoggerFactory.getLogger(CustomCredentialValidator.class);

    private static final String USER_PATTERN = "^[a-zA-Z0-9_.+-]+$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    @Override
    public CredentialValidationResult validate(CredentialContext context) {
        String userId = context.getIdentifier();
        String password = context.getPasswordAsString();

        if (!isValidUser(userId)) {
            logger.warn("Invalid user: {}", userId);
            return CredentialValidationResult.failure("INVALID_USER");
        }

        if (!isValidPassword(password)) {
            logger.warn("Invalid password: {}", password);
            return CredentialValidationResult.failure("INVALID_PASSWORD");
        }

        return CredentialValidationResult.success();
    }

    private boolean isValidUser(String userId) {
        return userId.matches(USER_PATTERN);
    }

    private boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}