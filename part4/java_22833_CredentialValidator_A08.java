import java.util.Base64;

public class java_22833_CredentialValidator_A08 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) {
        String enteredUsername = "user";
        String enteredPassword = "pass";

        if (authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }

    public static boolean authenticate(String username, String password) {
        // convert entered credentials to Base64 for comparison
        String usernameEncoded = Base64.getEncoder().encodeToString(username.getBytes());
        String passwordEncoded = Base64.getEncoder().encodeToString(password.getBytes());

        // compare entered credentials with hard-coded credentials
        return usernameEncoded.equals(USERNAME) && passwordEncoded.equals(PASSWORD);
    }
}