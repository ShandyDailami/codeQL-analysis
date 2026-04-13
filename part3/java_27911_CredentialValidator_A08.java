import java.util.Base64;

public class java_27911_CredentialValidator_A08 {

    // This method checks if the username and password match with the hardcoded values
    public boolean validate(String username, String password) {
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        // Decode base64 to get username and password
        byte[] decodedUsernameBytes = Base64.getDecoder().decode(username);
        byte[] decodedPasswordBytes = Base64.getDecoder().decode(password);
        String decodedUsername = new String(decodedUsernameBytes);
        String decodedPassword = new String(decodedPasswordBytes);

        // Validate username and password
        return decodedUsername.equals(hardcodedUsername) && decodedPassword.equals(hardcodedPassword);
    }

}