public class java_11513_CredentialValidator_A08 {
    // hardcoded set of credentials
    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static boolean validate(String username, String password) {
        // check if the provided username and password match the hardcoded credentials
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // test the validator
        boolean valid = validate("user", "pass");
        if (valid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}