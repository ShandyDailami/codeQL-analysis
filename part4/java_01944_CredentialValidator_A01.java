import java.util.Base64;

public class java_01944_CredentialValidator_A01 {

    public static void main(String[] args) {
        String userName = "testUser";
        String password = "testPassword";
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Simulating login attempt
        if (isValidCredentials(userName, encodedPassword)) {
            System.out.println("Access granted for user: " + userName);
        } else {
            System.out.println("Access denied for user: " + userName);
        }
    }

    private static boolean isValidCredentials(String userName, String encodedPassword) {
        // Simulating database query
        if (userName.equals("testUser") && encodedPassword.equals("testPassword")) {
            return true;
        } else {
            return false;
        }
    }
}