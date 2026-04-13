import java.util.Base64;

public class java_22093_CredentialValidator_A03 {

    // Method to validate the credentials
    public boolean validate(String user, String password) {
        // This is a placeholder for a real authentication system
        // In a real application, the password would be encrypted using a hash function
        // and then compared to a stored hash.

        // For this example, let's pretend the username is "admin" and the password is "password".
        String correctUser = "admin";
        String correctPassword = "password";

        // Decode the base64 encoded passwords for comparison
        byte[] decodedPassword = Base64.getDecoder().decode(correctPassword);
        String decodedCorrectPassword = new String(decodedPassword);

        // Compare the entered password to the expected password
        if (user.equals(correctUser) && password.equals(decodedCorrectPassword)) {
            return true;
        } else {
            return false;
        }
    }
}