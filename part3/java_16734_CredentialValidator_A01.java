public class java_16734_CredentialValidator_A01 {
    // Storing the predefined rules
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]{5,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_PATTERN);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }

    public boolean validateCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}