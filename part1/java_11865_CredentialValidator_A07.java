public class java_11865_CredentialValidator_A07 {

    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpassword";

    public static boolean validate(String inputUsername, String inputPassword) {
        return USERNAME.equals(inputUsername) && PASSWORD.equals(inputPassword);
    }

    public static void main(String[] args) {
        // You can replace these with actual values when you're actually running the program.
        String testUsername = "testuser";
        String testPassword = "testpassword";

        if (validate(testUsername, testPassword)) {
            System.out.println("Credentials valid.");
        } else {
            System.out.println("Credentials invalid.");
        }
    }
}