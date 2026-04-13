import java.util.Base64;
import java.util.Map;

public class java_19175_CredentialValidator_A01 {
    public static final String AUTHENTICATED_USER = "AuthenticatedUser";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";

    private Map<String, String> users;

    public java_19175_CredentialValidator_A01(Map<String, String> users) {
        this.users = users;
    }

    public boolean isValidCredentials(String user, String password) {
        String expectedPassword = users.get(user);
        if (expectedPassword == null) {
            return false;
        }
        byte[] expectedPasswordBytes = Base64.getDecoder().decode(expectedPassword);
        byte[] providedPasswordBytes = Base64.getDecoder().decode(password);
        return Arrays.equals(expectedPasswordBytes, providedPasswordBytes);
    }
}