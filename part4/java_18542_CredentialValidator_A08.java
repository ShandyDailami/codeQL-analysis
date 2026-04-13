import java.util.Base64;

public class java_18542_CredentialValidator_A08 {

    public static class PasswordValidator {

        public static boolean validate(String password) {
            if (password == null || password.length() < 8) {
                return false;
            }

            // Check if the password contains at least one uppercase letter
            if (!password.equals(Character.toString(password.toUpperCase().charAt(0)))) {
                return false;
            }

            // Check if the password contains at least one lowercase letter
            if (!password.equals(Character.toString(password.toLowerCase().charAt(0)))) {
                return false;
            }

            // Check if the password contains at least one digit
            if (!password.matches(".*\\d.*")) {
                return false;
            }

            // Check if the password contains at least one special character
            if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
                return false;
            }

            return true;
        }

    }

    public static void main(String[] args) {
        String password = "ThisIsAStrongPassword!";
        System.out.println("Password is valid: " + PasswordValidator.validate(password));
    }

}