public class java_10738_CredentialValidator_A08 {

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]+$";
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    public boolean isUsernameValid(String username) {
        return username.matches(USERNAME_REGEX);
    }

    public boolean isPasswordValid(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public boolean isCredentialsValid(String username, String password) {
        return isUsernameValid(username) && isPasswordValid(password);
    }
}