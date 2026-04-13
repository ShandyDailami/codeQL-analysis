import java.util.Base64;

public class java_14849_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        // This is a placeholder for a real world application.
        // In a real world application, we would use a secure method to store the username and password
        // and compare the provided password with the stored one.

        // For now, let's assume the password is correct.
        // We should never compare passwords in a real world application.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String username = "admin";
        String password = "password";

        if (validate(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
    }
}