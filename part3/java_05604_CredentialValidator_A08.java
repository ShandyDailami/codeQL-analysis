import java.util.Base64;

public class java_05604_CredentialValidator_A08 {
    public static boolean validateCredentials(String username, String password) {
        // For simplicity, we'll assume these are hardcoded into the program
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Convert the username and password to Base64
        String base64Username = Base64.getEncoder().encodeToString(username.getBytes());
        String base64Password = Base64.getEncoder().encodeToString(password.getBytes());

        // Compare the Base64 encoded strings to the hardcoded ones
        return hardcodedUsername.equals(base64Username) && hardcodedPassword.equals(base64Password);
    }
}