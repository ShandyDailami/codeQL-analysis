public class java_33650_CredentialValidator_A07 {

    // Hardcoded credentials
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    // Credential Validator
    public static boolean validate(String username, String password) {
        return (username.equals(USERNAME) && password.equals(PASSWORD));
    }

    public static void main(String[] args) {
        // Testing
        System.out.println("Is valid: " + validate("test", "password"));
        System.out.println("Is valid: " + validate("wrong", "password"));
        System.out.println("Is valid: " + validate("test", "wrong"));
        System.out.println("Is valid: " + validate("wrong", "wrong"));
    }
}