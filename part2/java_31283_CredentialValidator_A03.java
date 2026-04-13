import java.util.Base64;

public class java_31283_CredentialValidator_A03 {
    private final UserService userService;

    public java_31283_CredentialValidator_A03(UserService userService) {
        this.userService = userService;
    }

    public void validateCredentials(String username, String password) {
        // Step 1: Retrieve user information from the database using userService.
        User user = userService.getUser(username);

        // Step 2: Decode the base64 encoded password from the user information.
        String decodedPassword = new String(Base64.getDecoder().decode(user.getPassword()));

        // Step 3: Compare the retrieved password with the password from the user information.
        if (decodedPassword.equals(password)) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }
}