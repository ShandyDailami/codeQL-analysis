import java.security.InvalidParameterException;

public class java_18698_CredentialValidator_A03 {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_.+-]+$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public static boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_PATTERN);
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_PATTERN);
    }

    public static boolean validate(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }
        // Here you can add your real authentication logic
        // For example, you can check if the username and password match a known user in a database
        // If they do, return true, otherwise return false
        return true;
    }
}