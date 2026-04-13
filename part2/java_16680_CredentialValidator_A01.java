import java.util.regex.Pattern;

public class java_16680_CredentialValidator_A01 {

    // Simple password checker
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Ensure password is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Ensure password contains at least one lowercase letter, one uppercase letter, and one number
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }

        // Password is valid
        return true;
    }

    public static void main(String[] args) {
        String passwords[] = {"password", "Password", "Password1", "Passw0rd@", "Password1$", "passw0rd$"};
        for (String password : passwords) {
            if (validatePassword(password)) {
                System.out.println("Password: " + password + " is valid");
            } else {
                System.out.println("Password: " + password + " is NOT valid");
            }
        }
    }
}