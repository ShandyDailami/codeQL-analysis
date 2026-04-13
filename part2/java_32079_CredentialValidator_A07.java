import java.security.InvalidParameterException;
import java.util.Base64;

public class java_32079_CredentialValidator_A07 {
    private static final String USER_DB = "myuser";
    private static final String PASSWORD_DB = "mypassword";

    public void validateCredentials(String user, String password) {
        if (!isValidUser(user, password)) {
            throw new InvalidParameterException("Invalid username or password");
        }
        // If validation is successful, continue to the next step
    }

    private boolean isValidUser(String user, String password) {
        String dbUser = new String(Base64.getDecoder().decode(user));
        String dbPassword = new String(Base64.getDecoder().decode(password));

        return dbUser.equals(USER_DB) && dbPassword.equals(PASSWORD_DB);
    }
}