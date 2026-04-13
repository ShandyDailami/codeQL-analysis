public class java_18713_CredentialValidator_A08 {

    // This is a hard-coded value in memory. It's a placeholder and not real data.
    private static String hardCodedPassword = "password";

    public static boolean validate(String password) {
        // If the password matches the hard-coded value, the validator returns true.
        // Otherwise, it returns false.
        if (password.equals(hardCodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        String testPassword = "wrongpassword";
        if (validate(testPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}