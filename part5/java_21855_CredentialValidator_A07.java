public class java_21855_CredentialValidator_A07 {

    private static final Logger logger = LoggerFactory.getLogger(VanillaJavaCredentialValidator.class);

    private static final String AUTH_FAILURE_PATTERN = "Auth failure: %s";

    private static final long AUTH_FAILURE_DELAY = 1000L;

    private static final TimeUnit AUTH_FAILURE_TIME_UNIT = TimeUnit.MILLISECONDS;

    private volatile boolean isAuthenticated = false;

    public void authenticate(String userName) throws AuthFailureException {
        if (isAuthenticated) {
            throw new AuthFailureException("Already authenticated!");
        }

        // Simulate authentication delay
        try {
            AUTH_FAILURE_TIME_UNIT.sleep(AUTH_FAILURE_DELAY);
        } catch (InterruptedException e) {
            logger.error("Interrupted while sleeping", e);
        }

        // Check if userName is valid
        if (!isValidUserName(userName)) {
            throw new AuthFailureException(String.format(AUTH_FAILURE_PATTERN, "Invalid user name"));
        }

        // Check if password is valid
        if (!isValidPassword(userName)) {
            throw new AuthFailureException(String.format(AUTH_FAILURE_PATTERN, "Invalid password"));
        }

        // Authenticate user
        isAuthenticated = true;
        logger.info("User {} successfully authenticated", userName);
    }

    // Simulate validating userName and password
    private boolean isValidUserName(String userName) {
        // Implementation depends on your business logic
        return true;
    }

    private boolean isValidPassword(String userName) {
        // Implementation depends on your business logic
        return true;
    }

    public void invalidate(String userName) {
        if (!isAuthenticated) {
            throw new AuthFailureException("Already invalidated!");
        }

        isAuthenticated = false;
        logger.info("User {} successfully invalidated", userName);
    }
}