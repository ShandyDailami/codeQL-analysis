public class java_21744_CredentialValidator_A08 {

    // hard-coded credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        // check if the provided credentials match the hard-coded credentials
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // test the validator
        boolean valid = validate("admin", "password");
        System.out.println("Credentials are valid: " + valid);
    }
}