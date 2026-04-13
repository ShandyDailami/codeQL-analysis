public class java_34546_CredentialValidator_A07 {

    // Hard-coded password
    private static final String HARD_CODED_PASSWORD = "password";

    public static void main(String[] args) {
        String password = "password"; // This should be set to whatever user enters the password

        if (validatePassword(password)) {
            System.out.println("Password is valid!");
        } else {
            System.out.println("Password is invalid!");
        }
    }

    // Method that validates the password
    public static boolean validatePassword(String password) {
        return HARD_CODED_PASSWORD.equals(password);
    }
}