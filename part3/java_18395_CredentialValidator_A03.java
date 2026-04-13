public class java_18395_CredentialValidator_A03 {
    private static final Logger logger = Logger.getLogger(CredentialValidator.class);

    public boolean isValidUsername(String username) {
        if (username == null || username.length() < 5) {
            logger.warning("Invalid username: " + username);
            return false;
        }

        // Here you could add more complex validation logic

        return true;
    }

    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            logger.warning("Invalid password: " + password);
            return false;
        }

        // Here you could add more complex validation logic

        return true;
    }

    public boolean areCredentialsValid(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            logger.warning("Invalid credentials: " + username + ", " + password);
            return false;
        }

        return true;
    }
}