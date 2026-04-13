public class java_09090_CredentialValidator_A08 {

    // Function to check the password
    public static boolean validatePassword(String password) {
        boolean isValid = true;
        if (password == null || password.length() < 8) {
            isValid = false;
        } else {
            if (!password.matches(".*[0-9].*")) {
                isValid = false;
            }
            if (!password.matches(".*[a-zA-Z].*")) {
                isValid = false;
            }
            if (!password.matches(".*[^a-zA-Z0-9].*")) {
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        String password = "YourPassword@123";
        if (validatePassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}