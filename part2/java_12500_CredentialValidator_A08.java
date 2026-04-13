public class java_12500_CredentialValidator_A08 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";
        validateCredentials(inputUsername, inputPassword);
    }

    public static void validateCredentials(String username, String password) {
        if (!username.equals(USERNAME) || !password.equals(PASSWORD)) {
            System.out.println("Invalid username or password");
        } else {
            System.out.println("Access granted");
        }
    }
}