import java.util.Base64;

public class java_35338_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean isValidCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String providedUsername = "admin";
        String providedPassword = "password";

        System.out.println("Is valid credentials: " + isValidCredentials(providedUsername, providedPassword));
    }
}