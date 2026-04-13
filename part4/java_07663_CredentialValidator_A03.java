public class java_07663_CredentialValidator_A03 {
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]+$";

    public boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_PATTERN) && username.length() >= 6;
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public boolean areCredentialsValid(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}