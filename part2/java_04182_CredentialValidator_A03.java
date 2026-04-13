public class java_04182_CredentialValidator_A03 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        if (validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}