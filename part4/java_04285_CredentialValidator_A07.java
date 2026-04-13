import java.util.Base64;

public class java_04285_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        String plainTextUsername = new String(Base64.getDecoder().decode(username));
        String plainTextPassword = new String(Base64.getDecoder().decode(password));

        // Replace with your own logic to check the credentials
        if (plainTextUsername.equals("admin") && plainTextPassword.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String encodedUsername = "d2VybmV0LWtleQ=="; // "admin" in base64
        String encodedPassword = "d2lzZW4="; // "password" in base64

        boolean isValid = validateCredentials(encodedUsername, encodedPassword);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}