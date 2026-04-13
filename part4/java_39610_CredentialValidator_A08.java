public class java_39610_CredentialValidator_A08 {
    private static final Logger logger = LoggerFactory.getLogger(CredentialValidator.class);

    public boolean validate(String userId, String password) {
        try {
            // Perform the security sensitive operation to check the user's credentials
            // Here, we'll simulate an operation by throwing an exception if the userId is not found in the system
            // In a real-world scenario, you'd use a secure method to authenticate the user
            if (!isUserIdExist(userId)) {
                logger.warn("UserId not found, invalid userId: " + userId);
                throw new CredentialException("Invalid userId");
            }

            if (!isPasswordValid(password)) {
                logger.warn("Invalid password, invalid password: " + password);
                throw new CredentialException("Invalid password");
            }

            // If the user's credentials are valid, return true
            return true;
        } catch (CredentialException e) {
            // Handle the exception appropriately, e.g., log the error and return false
            logger.error("Failed to validate credentials for userId: " + userId, e);
            return false;
        }
    }

    private boolean isUserIdExist(String userId) {
        // Simulate the operation of checking if a userId exists
        // In a real-world scenario, you'd use a secure method to authenticate the user
        return userId != null;
    }

    private boolean isPasswordValid(String password) {
        // Simulate the operation of validating a password
        // In a real-world scenario, you'd use a secure method to authenticate the user
        return password != null;
    }
}