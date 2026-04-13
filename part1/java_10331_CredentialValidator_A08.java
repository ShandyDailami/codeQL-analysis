public class java_10331_CredentialValidator_A08 {

    // hardcoded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // method to validate the credentials
    public static boolean validate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    // main method for testing
    public static void main(String[] args) {
        System.out.println(validate("admin", "password")); // should print true
        System.out.println(validate("user", "wrongpassword")); // should print false
    }
}