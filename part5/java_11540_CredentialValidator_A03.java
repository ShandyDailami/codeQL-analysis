public class java_11540_CredentialValidator_A03 {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPass";

    public static void main(String[] args) {
        String username = "invalidUser";
        String password = "invalidPass";

        if (validateCredentials(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private static boolean validateCredentials(String username, String password) {
        // In a real-world scenario, we would need to use a database here
        // to compare the entered username and password with the ones in the database.
        // This is just a placeholder.
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}