public class java_03158_CredentialValidator_A03 {

    public static boolean isPasswordStrong(String password) {
        // Checking if password is null
        if (password == null) {
            return false;
        }

        // Checking if password is too short (6 characters minimum)
        if (password.length() < 6) {
            return false;
        }

        // Checking if password contains a digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // Checking if password contains a special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // If the password passed all the checks, it is strong
        return true;
    }

    public static void main(String[] args) {
        String password = "Password@123";
        if (isPasswordStrong(password)) {
            System.out.println("The password is strong");
        } else {
            System.out.println("The password is weak");
        }
    }
}