public class java_30206_CredentialValidator_A07 {

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Define the criteria for a password
        boolean hasUpperCase = password.matches("(?=.*[A-Z])");
        boolean hasLowerCase = password.matches("(?=.*[a-z])");
        boolean hasDigit = password.matches("(?=.*[0-9])");
        boolean isValidLength = password.length() >= 8;

        // Check all criteria
        if (!(hasUpperCase && hasLowerCase && hasDigit && isValidLength)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String password = "Password1!";
        boolean isValid = CredentialValidator.validatePassword(password);
        System.out.println("Is password valid? " + (isValid ? "Yes" : "No"));
    }
}