public class java_05644_CredentialValidator_A01 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Test the validator
        boolean result = validate("admin", "password");
        if(result) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}