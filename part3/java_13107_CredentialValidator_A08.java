public class java_13107_CredentialValidator_A08 {

    // hard-coded credentials for demonstration
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // You can call this method to test the credentials
        if (validate("user", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}