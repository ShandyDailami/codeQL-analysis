public class java_25617_CredentialValidator_A03 {

    // Define the minimum criteria
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_=-{}[]|\\:;<>,.?/`";

    // Main method to test the password validator
    public static void main(String[] args) {
        String password = "strongPassword@123";
        System.out.println(validatePassword(password));
    }

    // Method to validate the password
    public static boolean validatePassword(String password) {
        // Check if the password is not null and has a length greater than MIN_PASSWORD_LENGTH
        if (password != null && password.length() > MIN_PASSWORD_LENGTH) {
            // Check if the password contains at least one digit and one special character
            boolean hasDigit = false;
            boolean hasSpecialChar = false;
            for (char c : password.toCharArray()) {
                if (Character.isDigit(c)) {
                    hasDigit = true;
                } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                    hasSpecialChar = true;
                }
            }
            // Return true only if both conditions are met
            return hasDigit && hasSpecialChar;
        }
        // Return false if the password is null or does not meet the minimum length
        return false;
    }
}