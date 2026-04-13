import java.security.Principal;

public class java_35816_CredentialValidator_A07 {
    public static boolean validateCredentials(String username, String password) {
        // Simulate checking against a database
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static Principal validate(String username, String password) {
        if (validateCredentials(username, password)) {
            return new Principal(username);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password"));
    }
}