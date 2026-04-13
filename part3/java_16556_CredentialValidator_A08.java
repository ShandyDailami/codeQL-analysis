import java.security.InvalidParameterException;
import java.security.cert.CertificateException;
import java.util.Base64;

public class java_16556_CredentialValidator_A08 {

    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]+$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z0-9]+$";

    public boolean isValidUsername(String username) {
        return username != null && username.matches(USERNAME_REGEX);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_REGEX);
    }

    public boolean isValidCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            throw new InvalidParameterException("Invalid username or password");
        }

        return true;
    }

    public static void main(String[] args) throws CertificateException, InvalidParameterException {
        CredentialValidator validator = new CredentialValidator();
        validator.isValidCredentials("username", "password");
    }
}