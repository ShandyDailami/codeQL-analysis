import java.util.Base64;

public class java_25828_CredentialValidator_A03 {
    public static boolean validate(String username, String password) {
        // Step 1: Encoding the password for security reasons
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // Step 2: Compare with stored password
        return checkPassword(username, encodedPassword);
    }

    private static boolean checkPassword(String username, String password) {
        // For simplicity, let's say we have a hardcoded set of usernames and their corresponding passwords
        String hardcodedPassword = "admin:$2a$10$e.WiYsqUKt3F41Zr5Fp.e9XqW.e.WiYsqUKt3F41Zr5Fp.e9XqW.";
        String[] hardcodedUsers = hardcodedPassword.split(":");

        for (String user : hardcodedUsers) {
            String[] userCredentials = user.split(":");
            if (username.equals(userCredentials[0]) && password.equals(userCredentials[1])) {
                return true;
            }
        }

        return false;
    }
}