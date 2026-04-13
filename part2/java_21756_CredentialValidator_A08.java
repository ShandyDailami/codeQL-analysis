public class java_21756_CredentialValidator_A08 {
    // Hardcoded passwords for simplicity
    private static final String hardcodedPassword = "password";

    // Method to validate the password
    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        // Check if the password provided matches the hardcoded password
        return password.equals(hardcodedPassword);
    }

    public static void main(String[] args) {
        // Testing the password validator
        String testPassword = "password";
        boolean isValid = validatePassword(testPassword);

        if (isValid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}