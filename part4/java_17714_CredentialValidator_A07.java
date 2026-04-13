public class java_17714_CredentialValidator_A07 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String inputUsername, String inputPassword) {
        // Check if the input username matches the predefined username
        if (!inputUsername.equals(USERNAME)) {
            System.out.println("Invalid username.");
            return false;
        }

        // Check if the input password matches the predefined password
        if (!inputPassword.equals(PASSWORD)) {
            System.out.println("Invalid password.");
            return false;
        }

        // If the username and password match, return true
        System.out.println("Credentials validated successfully.");
        return true;
    }

    public static void main(String[] args) {
        validate("admin", "password");
    }
}