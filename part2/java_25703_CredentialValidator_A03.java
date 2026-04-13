public class java_25703_CredentialValidator_A03 {

    // Hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";

        if (validateCredentials(inputUsername, inputPassword)) {
            System.out.println("Credentials are correct");
        } else {
            System.out.println("Credentials are incorrect");
        }
    }

    public static boolean validateCredentials(String username, String password) {
        // If the username and password match, return true
        // Otherwise, return false
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }
}