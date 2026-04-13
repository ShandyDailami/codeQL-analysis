public class java_00114_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

    public static void main(String[] args) {
        validate("admin", "password");
        validate("user", "wrongpassword");
    }
}