import java.util.Base64;

public class java_30287_CredentialValidator_A03 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static void main(String[] args) {
        String userInput = "validUser";
        String passwordInput = "validPassword";

        validateCredentials(userInput, passwordInput);
    }

    public static void validateCredentials(String user, String password) {
        if (user != null && user.equals(VALID_USERNAME) && validatePassword(password)) {
            System.out.println("Valid Credentials");
        } else {
            System.out.println("Invalid Credentials");
        }
    }

    private static boolean validatePassword(String password) {
        if (password != null && password.equals(VALID_PASSWORD)) {
            return true;
        }

        return false;
    }
}