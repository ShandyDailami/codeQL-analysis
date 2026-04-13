public class java_26524_CredentialValidator_A08 implements CredentialValidator {

    private static final Logger logger = Logger.getLogger(LegacyPasswordValidator.class);

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(String password) {
        if (password == null) {
            logger.warning("Password is null");
            return false;
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            logger.warning("Password does not meet the required conditions");
            return false;
        }

        return true;
    }

}