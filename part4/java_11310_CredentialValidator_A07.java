public class java_11310_CredentialValidator_A07 implements CredentialValidator {

    private static final Logger log = LoggerFactory.getLogger(AuthFailureValidator.class);

    @Override
    public boolean validate(CredentialValidationResult validationResult) {
        // if the Credential is valid, the validationResult is considered successful
        if (validationResult.isValid()) {
            log.debug("User is successfully authenticated.");
            return true;
        }

        // if the Credential is not valid, the validationResult is considered failure
        if (validationResult.failed()) {
            log.error("Authentication failed for user {}.", validationResult.getUserDetails().getUsername());
            return false;
        }

        // if some other error occurred, return false
        log.error("An error occurred while validating the user {}.", validationResult.getUserDetails().getUsername());
        return false;
    }
}