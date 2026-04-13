public class java_05291_CredentialValidator_A08 {

    public static void main(String[] args) {
        String password = "Password@123";
        if (validate(password)) {
            System.out.println("Valid Password");
        } else {
            System.out.println("Invalid Password");
        }
    }

    public static boolean validate(String password) {
        // minimum length of 8 characters
        if (password.length() < 8) {
            return false;
        }

        // check if password contains at least one number
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        // check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return false;
        }

        // check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }

        return true;
    }
}