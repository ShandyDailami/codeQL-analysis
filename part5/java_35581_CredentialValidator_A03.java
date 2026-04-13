import java.util.Base64;

public class java_35581_CredentialValidator_A03 {

    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";

    public static void main(String[] args) {
        validateCredentials("user", "password");
    }

    public static void validateCredentials(String username, String password) {
        if (isValidUsername(username) && isValidPassword(password)) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    private static boolean isValidUsername(String username) {
        // Here we assume if the username is "user" then it's valid
        return username.equals(USERNAME);
    }

    private static boolean isValidPassword(String password) {
        // Here we assume if the password is "password" then it's valid
        // In real scenario, passwords should not be stored in plaintext as it makes them vulnerable to attacks.
        // We're using Base64 decoding here for simplification.
        try {
            return password.equals(new String(Base64.getDecoder().decode(PASSWORD)));
        } catch (Exception e) {
            // In case of an error decoding the password, it's not valid.
            return false;
        }
    }
}