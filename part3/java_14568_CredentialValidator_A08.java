public class java_14568_CredentialValidator_A08 {

    private static final String PREDEFINED_PASSWORD = "password";

    public static void main(String[] args) {
        // Testing the method
        System.out.println(validateCredentials("password"));
    }

    // Method that validates the user's password
    public static boolean validateCredentials(String userPassword) {
        // Return true if the password matches, false otherwise
        return userPassword.equals(PREDEFINED_PASSWORD);
    }
}