import java.util.Base64;

public class java_29081_CredentialValidator_A03 {

    public boolean validateUserCredentials(String username, String password) {
        // Encoding the plain text password
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());

        // For demonstration purposes, this is a mock authentication process
        // You can replace this with actual authentication process with a database or an API
        if (username.equals("admin") && encodedPassword.equals("YWRtaW4=")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        if (validator.validateUserCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}